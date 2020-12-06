package com.seguro.residencial.domain.events.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.CotacaoResource;
import com.seguro.residencial.domain.events.cotacoes.CotacaoStatusAtualizadaEvent;
import com.seguro.residencial.domain.events.cotacoes.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.NegocioException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoImpressaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
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
@RequiredArgsConstructor
public class CotacaoCommandHandler {

    private static final String CALCULADA = "CALCULADA";
    private static final String AGUARDANDO_PAGAMENTO = "AGUARDANDO_PAGAMENTO";
    private static final String COTACAO_RESIDENCIAL = "cotacao-residencial";

    private final ICotacaoRepository cotacaoRepository;
    private final ICotacaoImpressaoRepository iCotacaoImpressaoRepository;
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
    public void on(CotacaoStatusAtualizadaEvent event) {

        var cotacao = cotacaoRepository.findByCodigoCotacao(event.getCodigoCotacao())
                .orElseThrow(() -> new CotacaoNaoEncontradaException(event.getCodigoCotacao()));

        var objImpressao = iCotacaoImpressaoRepository.consultarCotacaoImpressao(event.getCodigoCotacao());

        atualzarObjCotacao(event, cotacao);

        if (event.getStatus().getDescricao().equals(CALCULADA)) {
            log.info("realizar envio de mensagem para servico de impressao");
            enviarDadosCotacaoImpressao(objImpressao);
        } else if (event.getStatus().getDescricao().equals(AGUARDANDO_PAGAMENTO)) {
            log.info("realizar envio de mensagem para servico de pagamento");
        }

        cotacaoRepository.save(cotacao);
    }


    private String converterParaJson(final CotacaoResource cotacaoResource) {
        try {
            return objectMapper.writeValueAsString(cotacaoResource);
        } catch (JsonProcessingException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    private void enviarDadosCotacaoImpressao(final CotacaoResource cotacaoResource) {
        String mensagem = converterParaJson(cotacaoResource);
        kafkaTemplate.send(COTACAO_RESIDENCIAL, mensagem);
    }

    private void atualzarObjCotacao(CotacaoStatusAtualizadaEvent event, CotacaoRoot cotacao) {
        cotacao.setStatus(event.getStatus());
        cotacao.setDataAtualizacao(OffsetDateTime.now());
    }
}

