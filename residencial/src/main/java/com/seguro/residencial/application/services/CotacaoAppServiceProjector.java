package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.exception.TipoCalculoNaoEncontradaException;
import com.seguro.residencial.domain.exception.TipoVigenciaNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ITipoCalculoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ITipoVigenciaRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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

    private final ITipoCalculoRepository tipoCalculoRepository;

    private final ITipoVigenciaRepository tipoVigenciaRepository;

    public CotacaoAppServiceProjector(CommandGateway commandGateway,
                                      ITipoCalculoRepository tipoCalculoRepository,
                                      ITipoVigenciaRepository tipoVigenciaRepository) {
        this.commandGateway = commandGateway;
        this.tipoCalculoRepository = tipoCalculoRepository;
        this.tipoVigenciaRepository = tipoVigenciaRepository;
    }

    @Override
    public CotacaoCriadaViewModel criacaoCotacao(CriarCotacaoInput input) {
        Random randow = new Random();

        var tipoVigencia = tipoVigenciaRepository.findById(input.getIdTipoVigencia())
                .orElseThrow(() -> new TipoVigenciaNaoEncontradaException(
                        input.getIdTipoVigencia()));

        var tipoCalculo = tipoCalculoRepository.findById(input.getIdTipoCalculo())
                .orElseThrow(() -> new TipoCalculoNaoEncontradaException(
                        input.getIdTipoCalculo()));

        var command = new CriarCotacaoCommand(randow.nextLong(),
                UUID.randomUUID().toString(),
                LocalDate.now(),
                input.getDataVigenciaInicial(),
                input.getDataVigenciaInicial(),
                tipoCalculo,
                tipoVigencia);

            commandGateway.send(command);

        return new CotacaoCriadaViewModel(command.getCodigoCotacao());
    }
}
