package com.seguros.relatorio.web.api.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguros.relatorio.application.assembler.relatorios.cotacoes.Cotacao;
import com.seguros.relatorio.application.interfaces.IImpressaoAppService;
import com.seguros.relatorio.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @criado 05/12/2020 - 20:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@AllArgsConstructor
@Component
@Slf4j
public class CotacaoListener {

    private static final String COTACAO_RESIDENCIAL = "cotacao-residencial";
    private static final String RELATORIO = "relatorio";

    private final ObjectMapper objectMapper;
    private final IImpressaoAppService impressaoAppService;

    @KafkaListener(topics = COTACAO_RESIDENCIAL, groupId = RELATORIO)
    public void lerMensagemCotacao(final String mensagem){
        try {
            var objCotacao = objectMapper.readValue(mensagem, Cotacao.class);
            impressaoAppService.registrarImpressaoCotacao(objCotacao);
        } catch (JsonProcessingException e) {
            throw new NegocioException(e.getMessage()) ;
        }

        log.info(mensagem);
    }

}
