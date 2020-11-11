package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.cotacao.RegistrarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoRegistradaViewModel;
import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;
import com.seguro.residencial.domain.exception.TipoCalculoNaoEncontradaException;
import com.seguro.residencial.domain.exception.TipoVigenciaNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ITipoCalculoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ITipoVigenciaRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CotacaoAppServiceProjector implements ICotacaoAppService {

    private final CommandGateway commandGateway;
    private final ITipoCalculoRepository tipoCalculoRepository;
    private final ITipoVigenciaRepository tipoVigenciaRepository;

    @Override
    public CotacaoRegistradaViewModel criacaoCotacao(RegistrarCotacaoInput input) {
        Random randow = new Random();

        var tipoVigencia = tipoVigenciaRepository.findById(input.getIdTipoVigencia())
                .orElseThrow(() -> new TipoVigenciaNaoEncontradaException(
                        input.getIdTipoVigencia()));

        var tipoCalculo = tipoCalculoRepository.findById(input.getIdTipoCalculo())
                .orElseThrow(() -> new TipoCalculoNaoEncontradaException(
                        input.getIdTipoCalculo()));

        var command = new RegistrarCotacaoCommand(randow.nextLong(),
                UUID.randomUUID().toString(),
                LocalDate.now(),
                input.getDataVigenciaInicial(),
                tipoCalculo,
                tipoVigencia);

            commandGateway.sendAndWait(command);

        return new CotacaoRegistradaViewModel(command.getCodigoCotacao());
    }
}
