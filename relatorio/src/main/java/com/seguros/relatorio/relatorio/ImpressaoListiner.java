package com.seguros.relatorio.relatorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @criado 25/11/2020 - 00:02
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Component
@AllArgsConstructor
@Slf4j
public class ImpressaoListiner {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "cotacao-residencial")
    public void lerMensagemCotacao(final String mensagem){
        log.info(mensagem);
    }

}
