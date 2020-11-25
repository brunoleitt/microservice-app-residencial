package com.seguro.residencial.domain.events.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro.residencial.application.assembler.kafka.ImpressaoCotacaoResource;
import com.seguro.residencial.domain.events.cotacoes.CotacaoStatusAtualizadaEvent;
import com.seguro.residencial.domain.events.cotacoes.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.exception.NegocioException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.IStatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * @criado 12/10/2020 - 21:43
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Slf4j
@Component
//@AllArgsConstructor
@RequiredArgsConstructor
public class CotacaoCommandHandler {

    private final ICotacaoRepository cotacaoRepository;
    private final IStatusCotacao iStatusCotacao;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

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

        var cotacao = cotacaoRepository.findByCodigoCotacao(event.getCodigoCotacao())
                .get();

        var statusCotacao = iStatusCotacao.findByDescricao(event.getStatus().getDescricao())
                .get();

        cotacao.setStatus(statusCotacao);
        cotacao.setDataAtualizacao(OffsetDateTime.now());

        if(event.getStatus().getDescricao().equals("CALCULADA")){
            log.info("realizar envio de mensagem para servico de impressao");
            enviarDadosCotacaoImpressao(cotacao);
        }else if(event.getStatus().getDescricao().equals("AGUARDANDO_PAGAMENTO")){
            log.info("realizar envio de mensagem para servico de pagamento");
        }

        cotacaoRepository.save(cotacao);
    }

    private String converterParaJson(final CotacaoRoot cotacaoRoot) {
        try {
            return objectMapper.writeValueAsString(new ImpressaoCotacaoResource(cotacaoRoot));
        } catch (JsonProcessingException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    public void enviarDadosCotacaoImpressao(final CotacaoRoot cotacaoRoot) {
        final String mensagem = converterParaJson(cotacaoRoot);
        kafkaTemplate.send("cotacao-residencial", mensagem);
    }

}

