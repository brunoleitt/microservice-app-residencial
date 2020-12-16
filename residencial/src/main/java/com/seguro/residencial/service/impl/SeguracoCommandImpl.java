package com.seguro.residencial.service.impl;

import com.seguro.residencial.domain.commands.cliente.RegistrarSeguradoCommand;
import com.seguro.residencial.domain.interfaces.repository.segurados.ISeguradoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.segurados.Profissao;
import com.seguro.residencial.domain.models.root.segurados.SeguradoRoot;
import com.seguro.residencial.domain.models.root.segurados.Sexo;
import com.seguro.residencial.service.ISeguradoCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @criado 15/12/2020 - 21:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class SeguracoCommandImpl implements ISeguradoCommand {

    private final ISeguradoRepository seguradoRepository;

    @Override
    public void command(RegistrarSeguradoCommand command) {

        var profissao = new Profissao();
        profissao.setId(command.getIdProfissao());

        var sexo = new Sexo();
        sexo.setId(command.getIdSexo());

        var cotacao = new CotacaoRoot();
        cotacao.setCodigoCotacao(command.getCodigoCotacao());

        var cliente = new SeguradoRoot(command.getId(),
                command.getNome(), command.getSobreNome(),
                command.getCpf(), command.getTelefone(),
                command.getRg(), command.getEmail(),
                command.getDataNascimento(), profissao, sexo, cotacao);

        seguradoRepository.save(cliente);
    }
}
