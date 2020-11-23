package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.cotacoes.CotacaoStatusAtualizadaEvent;
import com.seguro.residencial.domain.events.cotacoes.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.IStatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
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
    private final IStatusCotacao iStatusCotacao;

    @EventHandler
    public void on(RegistradaCotacaoEvent event) {

        var cotacao = new CotacaoRoot(event.getCodigoCotacao(), event.getStatusCotacao(),
                event.getDataCotacao(), event.getDataVigenciaInicial(),
                event.getDataVigenciaFinal(), event.getTipoCalculo(),
                event.getTipoVigencia());

        cotacaoRepository.save(cotacao);
    }

    @EventHandler
    public void on(CotacaoStatusAtualizadaEvent event){

        var cotacao = (CotacaoRoot) cotacaoRepository.findByCodigoCotacao(event.getCodigoCotacao())
                .get();

        var statusCotacao = (StatusCotacao) iStatusCotacao.findByDescricao(event.getStatusNovo())
                .get();

        cotacao.setStatus(statusCotacao);

        if(event.getStatusNovo().equals("CALCULADA")){
            //TODO realizar envio de mensagem para servico de impressao
        }else if(event.getStatusNovo().equals("PAGAMENTEPENDENTE")){
            //TODO realizar envio de mensagem para servico de pagamento
        }

        cotacaoRepository.save(cotacao);
    }

}

