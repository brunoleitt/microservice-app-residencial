package com.seguro.residencial.domain.commands.handlers;

import com.seguro.residencial.coreapi.model.baseevent.BaseEvent;
import com.seguro.residencial.domain.aggregates.CotacaoAggregate;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 15:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
public class CriarCotacaoQueryCommandHandler {

    @Autowired
    private ICotacaoQueryRepository cotacaoRepository;

    /**
     *  EventSourcingRepository gerenciado pelo Axo gerencia a classe agregada que ira utilizar para
     * para escutar os comandos enviados da aplicação
     * */
    @Autowired
    @Qualifier("cotacaoAggregateEventSourcingRepository")
    private EventSourcingRepository<CotacaoAggregate> cotacaoAggregateEventSourcingRepository;

    /*
     * Escuta todos os eventos que ocorrem no agregado
     * */
    @EventSourcingHandler
    void on(BaseEvent baseEvent){
        persistCotacao(buildQueryCotacao(getAccountFromEvent(baseEvent)));
    }

    private CotacaoAggregate getAccountFromEvent(BaseEvent baseEvent){
        return cotacaoAggregateEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    /**
     *  Verifica se existe um objeto no banco de dados com o mesmo ID, caso contrario, ira realizar a persistencia de
     * novo objeto
     * @param id
     * @return
     */
    private com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery findExistingOrCreateQueryAccount(String id){
        return cotacaoRepository.findById(id).isPresent() ? cotacaoRepository.findById(id).get() : new com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery();
    }


    private com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery buildQueryCotacao(CotacaoAggregate cotacaoAggregate){
        com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery cotacaoQueryEntity = findExistingOrCreateQueryAccount(cotacaoAggregate.getId());

        cotacaoQueryEntity.setId(cotacaoAggregate.getId());
        cotacaoQueryEntity.setTitulo(cotacaoAggregate.getTitulo());

        return cotacaoQueryEntity;
    }


    private void persistCotacao(com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery cotacaoQueryEntity){
        cotacaoRepository.save(cotacaoQueryEntity);
    }

}
