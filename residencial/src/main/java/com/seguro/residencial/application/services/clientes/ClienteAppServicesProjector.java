package com.seguro.residencial.application.services.clientes;

import com.seguro.residencial.application.interfaces.clientes.IClienteAppService;
import com.seguro.residencial.application.models.input.cliente.ClienteInput;
import com.seguro.residencial.domain.commands.cliente.RegistrarClienteCommand;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.clientes.ProfissaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.clientes.SexoNaoEncontradoException;
import com.seguro.residencial.domain.interfaces.repository.cliente.IProfissaoRepository;
import com.seguro.residencial.domain.interfaces.repository.cliente.ISexoRepository;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @criado 21/11/2020 - 14:48
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class ClienteAppServicesProjector implements IClienteAppService {

    private final CommandGateway commandGateway;

    private final ISexoRepository iSexoRepository;

    private final IProfissaoRepository iProfissaoRepository;

    private final ICotacaoRepository iCotacaoRepository;

    @Override
    public void registrarCliente(ClienteInput input, String codigoCotacao) {

        var profissao = iProfissaoRepository.findById(input.getIdProfissao())
                .orElseThrow(() -> new ProfissaoNaoEncontradaException(input.getIdProfissao()));
        input.setIdProfissao(profissao.getId());

        var sexo = iSexoRepository.findById(input.getIdSexo())
                .orElseThrow(() -> new SexoNaoEncontradoException(input.getIdSexo()));
        input.setIdSexo(sexo.getId());

        Long idCotacao = iCotacaoRepository.consultarIdCotacao(codigoCotacao)
                .orElseThrow(() -> new CotacaoNaoEncontradaException(codigoCotacao));

        var command = new RegistrarClienteCommand(new Random().nextLong(),
                input.getNome(), input.getSobreNome(),
                input.getCpf(), input.getTelefone(),
                input.getRg(), input.getEmail(),
                input.getDataNascimento(), idCotacao,
                input.getIdProfissao(), input.getIdSexo());

        command.isValid();

        commandGateway.sendAndWait(command);

    }
}
