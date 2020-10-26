package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriacaoCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoQuery;
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

//    @Autowired
//    private ICotacaoQueryRepository iCotacaoQueryRepository;
//
//
//    @EventHandler
//    void on(CriacaoCotacaoEvent criacaoCotacaoEvent){
//        persistCotacao(buildQueryCotacao(criacaoCotacaoEvent));
//    }
//
//    private CotacaoQuery buildQueryCotacao(CriacaoCotacaoEvent criacaoCotacaoEvent){
//        CotacaoQuery cotacaoQuery = new CotacaoQuery();
//        cotacaoQuery.setId(criacaoCotacaoEvent.getId());
//        return cotacaoQuery;
//    }
//
//    private void persistCotacao(CotacaoQuery CotacaoQuery){
//        iCotacaoQueryRepository.save(CotacaoQuery);
//    }

}
