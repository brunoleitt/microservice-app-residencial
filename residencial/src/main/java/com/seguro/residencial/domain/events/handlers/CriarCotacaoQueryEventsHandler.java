package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriacaoCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import com.seguro.residencial.domain.models.root.cotacao.CotacaoQuery;
import com.seguro.residencial.domain.querys.cotacao.FindCotacaoQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 15:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
@Slf4j
public class CriarCotacaoQueryEventsHandler {

    @Autowired
    private ICotacaoQueryRepository iCotacaoQueryRepository;


    @EventHandler
    void on(CriacaoCotacaoEvent criacaoCotacaoEvent){
        persistCotacao(buildQueryCotacao(criacaoCotacaoEvent));
    }


    private CotacaoQuery buildQueryCotacao(CriacaoCotacaoEvent criacaoCotacaoEvent){
        CotacaoQuery cotacaoQuery = new CotacaoQuery();
        cotacaoQuery.setId(criacaoCotacaoEvent.getId());
        cotacaoQuery.setTitulo(criacaoCotacaoEvent.getTitulo());
        return cotacaoQuery;
    }


    private void persistCotacao(CotacaoQuery CotacaoQuery){
        iCotacaoQueryRepository.save(CotacaoQuery);
    }


    @QueryHandler
    public CotacaoQuery handle(FindCotacaoQuery query) {
        log.debug("Handling FindBankAccountQuery query: {}", query);
        return this.iCotacaoQueryRepository.findById(query.getId()).orElse(null);
    }

}


/**
 *  EventSourcingRepository gerenciado pelo Axo gerencia a classe agregada que ira utilizar para
 * para escutar os comandos enviados da aplicação
 * */
//    @Autowired
//    @Qualifier("cotacaoAggregateEventSourcingRepository")
//    private EventSourcingRepository<CotacaoAggregate> cotacaoAggregateEventSourcingRepository;


//    private CotacaoAggregate getAccountFromEvent(BaseEvent baseEvent){
//        return cotacaoAggregateEventSourcingRepository.load(baseEvent.id.toString()).getWrappedAggregate().getAggregateRoot();
//    }

/**
 *  Verifica se existe um objeto no banco de dados com o mesmo ID, caso contrario, ira realizar a persistencia de
 * novo objeto
 * @param id
 * @return
 */

/*
 * Escuta todos os eventos que ocorrem no agregado
 * */