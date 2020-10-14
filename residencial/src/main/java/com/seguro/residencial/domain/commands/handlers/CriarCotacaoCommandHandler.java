package com.seguro.residencial.domain.commands.handlers;

import com.seguro.residencial.coreapi.model.baseevent.BaseEvent;
import com.seguro.residencial.domain.aggregates.CotacaoAggregate;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacao.Cotacao;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * Realiza chamada Validação de negocios antes de realizar a persistencia.
 *
 */
@Component
public class CriarCotacaoCommandHandler {

    @Autowired
    private ICotacaoRepository cotacaoRepository;

    @Autowired
    @Qualifier("cotacaoAggregateEventSourcingRepository")
    private EventSourcingRepository<CotacaoAggregate> cotacaoAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent baseEvent){
        persistCotacao(buildQueryCotacao(getAccountFromEvent(baseEvent)));
    }

    private CotacaoAggregate getAccountFromEvent(BaseEvent baseEvent){
        return cotacaoAggregateEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private Cotacao findExistingOrCreateQueryAccount(String id){
        return cotacaoRepository.findById(id).isPresent() ? cotacaoRepository.findById(id).get() : new Cotacao();
    }

    private Cotacao buildQueryCotacao(CotacaoAggregate cotacaoAggregate){
        Cotacao cotacao = findExistingOrCreateQueryAccount(cotacaoAggregate.getId());
        cotacao.setId(cotacaoAggregate.getId());
        cotacao.setTitulo(cotacaoAggregate.getTitulo());
        return cotacao;
    }


    private void persistCotacao(Cotacao cotacao){
        cotacaoRepository.save(cotacao);
    }

}
