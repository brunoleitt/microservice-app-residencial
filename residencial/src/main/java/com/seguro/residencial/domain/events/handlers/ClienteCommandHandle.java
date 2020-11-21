package com.seguro.residencial.domain.events.handlers;

import com.seguro.residencial.domain.events.clientes.ClienteRegistradoEvent;
import com.seguro.residencial.domain.interfaces.repository.cliente.IClienteRepository;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.clientes.Profissao;
import com.seguro.residencial.domain.models.root.clientes.Sexo;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @criado 21/11/2020 - 12:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Component
@AllArgsConstructor
public class ClienteCommandHandle {

    private final IClienteRepository clienteRepository;

    @EventHandler
    public void on(ClienteRegistradoEvent event) {

        var profissao = new Profissao();
        profissao.setId(event.getIdProfissao());

        var sexo = new Sexo();
        sexo.setId(event.getIdSexo());

        var cotacao = new CotacaoRoot();
        cotacao.setId(event.getIdCotacao());

        var cliente = new ClienteRoot(new Random().nextLong(),
                event.getNome(), event.getSobreNome(),
                event.getCpf(), event.getTelefone(),
                event.getRg(), event.getEmail(),
                event.getDataNascimento(), profissao, sexo, cotacao);

        clienteRepository.save(cliente);
    }
}
