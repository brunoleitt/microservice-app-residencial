package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @criado 12/10/2020 - 15:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoAppServiceProjector implements ICotacaoAppService {

    private final CommandGateway commandGateway;


    public CotacaoAppServiceProjector(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CotacaoCriadaViewModel criacaoCotacao(CriarCotacaoInput input) {
        Random random = new Random();

        var registrarCotacaoCommand = new CriarCotacaoCommand(random.nextLong(),
                UUID.randomUUID().toString(),
                LocalDate.now(),
                input.getDataVigenciaInicial(),
                input.getDataVigenciaFinal(),
                input.getIdTipoCalculo(),
                input.getIdTipoVigencia(),
                null,
                null,
                null);

        commandGateway.send(registrarCotacaoCommand);

        //TODO Criacao para realizar o MAP de Command -> ViewModel
        var cotacaoCriadaViewModel = new CotacaoCriadaViewModel();

        cotacaoCriadaViewModel.setCodigoCotacao(registrarCotacaoCommand.getCodigoCotacao());


        return cotacaoCriadaViewModel;
    }
}
