package com.seguro.residencial.application.services.clientes;

import com.seguro.residencial.application.interfaces.segurados.ISeguradoAppService;
import com.seguro.residencial.application.models.input.segurados.SeguradoInput;
import com.seguro.residencial.domain.commands.cliente.RegistrarSeguradoCommand;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.clientes.ProfissaoNaoEncontradaException;
import com.seguro.residencial.domain.exception.clientes.SexoNaoEncontradoException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoRepository;
import com.seguro.residencial.domain.interfaces.repository.segurados.IProfissaoRepository;
import com.seguro.residencial.domain.interfaces.repository.segurados.ISexoRepository;
import com.seguro.residencial.service.ISeguradoCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @criado 21/11/2020 - 14:48
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class SeguradoAppServicesImpl implements ISeguradoAppService {

    private final ISeguradoCommand iSeguradoCommand;

    private final ISexoRepository iSexoRepository;

    private final IProfissaoRepository iProfissaoRepository;

    private final ICotacaoRepository iCotacaoRepository;

    @Override
    public void registraSegurado(SeguradoInput input, String codigoCotacao) {

        var profissao = iProfissaoRepository.findById(input.getIdProfissao())
                .orElseThrow(() -> new ProfissaoNaoEncontradaException(input.getIdProfissao()));
        input.setIdProfissao(profissao.getId());

        var sexo = iSexoRepository.findById(input.getIdSexo())
                .orElseThrow(() -> new SexoNaoEncontradoException(input.getIdSexo()));
        input.setIdSexo(sexo.getId());

        iCotacaoRepository.consultarCodigoCotacao(codigoCotacao)
                .orElseThrow(() -> new CotacaoNaoEncontradaException(codigoCotacao));

        var command = new RegistrarSeguradoCommand(UUID.randomUUID().toString(),
                input.getNome(), input.getSobreNome(),
                input.getCpf(), input.getTelefone(),
                input.getRg(), input.getEmail(),
                input.getDataNascimento(), codigoCotacao,
                input.getIdProfissao(), input.getIdSexo());

        command.isValid();

        iSeguradoCommand.command(command);

    }
}
