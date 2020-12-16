package com.seguro.residencial.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.CotacaoResource;
import com.seguro.residencial.domain.commands.cotacoes.AtualizarStatusCotacaoCommand;
import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.NegocioException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoImpressaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.service.ICotacaoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

/**
 * @criado 15/12/2020 - 19:27
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class CotacaoCommand implements ICotacaoCommand {


    private static final String CALCULADA = "CALCULADA";
    private static final String AGUARDANDO_PAGAMENTO = "AGUARDANDO_PAGAMENTO";
    private static final String COTACAO_RESIDENCIAL = "cotacao-residencial";

    private final ICotacaoRepository cotacaoRepository;
    private final ICotacaoImpressaoRepository iCotacaoImpressaoRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    @Override
    public void command(RegistrarCotacaoCommand command) {
        var cotacao = new CotacaoRoot(command.getCodigoCotacao(), command.getStatus(),
                command.getDataCotacao(), command.getDataVigenciaInicial(),
                command.getDataVigenciaFinal(), command.getTipoCalculo(),
                command.getTipoVigencia());

        cotacaoRepository.save(cotacao);
    }

    @Override
    public void command(AtualizarStatusCotacaoCommand command) {

        var cotacao = cotacaoRepository.findByCodigoCotacao(command.getCodigoCotacao())
                .orElseThrow(() -> new CotacaoNaoEncontradaException(command.getCodigoCotacao()));

        var objImpressao = iCotacaoImpressaoRepository.consultarCotacaoImpressao(command.getCodigoCotacao());

        atualzarObjCotacao(command, cotacao);

        if (command.getStatus().getDescricao().equals(CALCULADA)) {
            log.info("realizar envio de mensagem para servico de impressao");
            enviarDadosCotacaoImpressao(objImpressao);
        } else if (command.getStatus().getDescricao().equals(AGUARDANDO_PAGAMENTO)) {
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

    private void atualzarObjCotacao(AtualizarStatusCotacaoCommand command, CotacaoRoot cotacao) {
        cotacao.setStatus(command.getStatus());
        cotacao.setDataAtualizacao(OffsetDateTime.now());
    }
}
