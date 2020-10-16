package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriacaoCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacao.Cotacao;
import com.seguro.residencial.domain.querys.cotacao.FindCotacaoQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class CriarCotacaoEventsHandler {

    @Autowired
    private ICotacaoRepository cotacaoRepository;

    @EventHandler
    void on(CriacaoCotacaoEvent criacaoCotacaoEvent){
        log.debug("Handling a Bank Account creation command {}", criacaoCotacaoEvent.id);
        persistCotacao(buildQueryCotacao(criacaoCotacaoEvent));
    }




    private Cotacao buildQueryCotacao(CriacaoCotacaoEvent criacaoCotacaoEvent){
        Cotacao cotacao = new Cotacao();
        cotacao.setId(criacaoCotacaoEvent.getId());
        cotacao.setTitulo(criacaoCotacaoEvent.getTitulo());
        return cotacao;
    }


    private void persistCotacao(Cotacao cotacao){
        cotacaoRepository.save(cotacao);
    }


    @QueryHandler
    public Cotacao handle(FindCotacaoQuery query) {
        log.debug("Handling FindBankAccountQuery query: {}", query);
        return this.cotacaoRepository.findById(query.getId()).orElse(null);
    }

}



//    @Autowired
//    @Qualifier("cotacaoAggregateEventSourcingRepository")
//    private EventSourcingRepository<CotacaoAggregate> cotacaoAggregateEventSourcingRepository;


//    private CotacaoAggregate getAccountFromEvent(BaseEvent baseEvent){
//        return cotacaoAggregateEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate().getAggregateRoot();
//    }