package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 12/10/2020 - 15:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoAppServiceProjector implements ICotacaoAppService {

    private final CommandGateway commandGateway;

    public CotacaoAppServiceProjector(CommandGateway _CommandGateway) {
        this.commandGateway = _CommandGateway;
    }

    @Override
    public CompletableFuture<String> criacaoCotacao(CriarCotacaoInput input) {
        Random random = new Random();

        return commandGateway.send(new CriarCotacaoCommand(random.nextLong(),
                OffsetDateTime.now(),
                OffsetDateTime.now(),
                OffsetDateTime.now(),
                input.getIdTipoCalculo(),
                input.getIdTipoVigencia(),
                null,
                null,
                null));
    }

}
