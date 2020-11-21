package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.cotacoes.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoStatus;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
@AllArgsConstructor
public class CotacaoCommandHandler {

    private final ICotacaoRepository cotacaoRepository;

    @EventHandler
    public void on(RegistradaCotacaoEvent event) {

        var cotacao = new CotacaoRoot(event.getCodigoCotacao(), CotacaoStatus.CRIADA.toString(),
                event.getDataCotacao(), event.getDataVigenciaInicial(),
                event.getDataVigenciaFinal(), event.getTipoCalculo(),
                event.getTipoVigencia());

        //TODO Realizar o envio da mensagem para base de impressao;

        cotacaoRepository.save(cotacao);
    }

}

