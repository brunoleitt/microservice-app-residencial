package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.clientes.ClienteRegistradoEvent;
import com.seguro.residencial.domain.interfaces.repository.segurados.ISeguradoRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.segurados.Profissao;
import com.seguro.residencial.domain.models.root.segurados.SeguradoRoot;
import com.seguro.residencial.domain.models.root.segurados.Sexo;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @criado 21/11/2020 - 12:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Component
@AllArgsConstructor
public class ClienteCommandHandle {

    private final ISeguradoRepository clienteRepository;

    @EventHandler
    public void on(ClienteRegistradoEvent event) {

        var profissao = new Profissao();
        profissao.setId(event.getIdProfissao());

        var sexo = new Sexo();
        sexo.setId(event.getIdSexo());

        var cotacao = new CotacaoRoot();
        cotacao.setCodigoCotacao(event.getCodigoCotacao());

        var cliente = new SeguradoRoot(event.getId(),
                event.getNome(), event.getSobreNome(),
                event.getCpf(), event.getTelefone(),
                event.getRg(), event.getEmail(),
                event.getDataNascimento(), profissao, sexo, cotacao);

        clienteRepository.save(cliente);
    }
}
