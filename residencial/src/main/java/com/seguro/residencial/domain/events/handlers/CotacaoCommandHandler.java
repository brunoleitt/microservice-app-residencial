package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.CriadaCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoStatus;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
public class CotacaoCommandHandler {


    private final ICotacaoRepository cotacaoRepository;

    public CotacaoCommandHandler(ICotacaoRepository repository) {
        this.cotacaoRepository = repository;
    }

    @EventHandler
    public void on(CriadaCotacaoEvent event) {

        var cotacao = new CotacaoRoot(event.getCodigoCotacao(), CotacaoStatus.CRIADA.toString(),
                event.getDataCotacao(), event.getDataVigenciaInicial(),
                event.getDataVigenciaFinal(), event.getTipoCalculo(),
                event.getTipoVigencia());

        //TODO Realizar o envio da mensagem para base de impressao;

        cotacaoRepository.save(cotacao);
    }
}

