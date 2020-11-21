package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.cliente.RegistrarClienteCommand;
import com.seguro.residencial.domain.events.clientes.ClienteRegistradoEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 21/11/2020 - 12:29
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@Aggregate
@NoArgsConstructor
public class ClienteAgreggate {

    @AggregateIdentifier
    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String telefone;
    private String rg;
    private String email;
    private LocalDate dataNascimento;
    private Long idCotacao;
    private Long idProfissao;
    private Long idSexo;


    @CommandHandler
    public ClienteAgreggate(RegistrarClienteCommand command) {
        AggregateLifecycle.apply(new ClienteRegistradoEvent(command.getId(), command.getNome(),
                command.getSobreNome(),command.getCpf(),
                command.getTelefone(),command.getRg(),
                command.getEmail(),command.getDataNascimento(),
                command.getIdCotacao(),command.getIdProfissao(),
                command.getIdSexo()));
    }

    @EventSourcingHandler
    public void on(ClienteRegistradoEvent event){
        this.setId(event.getId());
        this.setNome(event.getNome());
        this.setSobreNome(event.getSobreNome());
        this.setCpf(event.getCpf());
        this.setTelefone(event.getTelefone());
        this.setRg(event.getRg());
        this.setEmail(event.getEmail());
        this.setDataNascimento(event.getDataNascimento());
        this.setIdCotacao(event.getIdCotacao());
        this.setIdProfissao(event.getIdProfissao());
        this.setIdSexo(event.getIdSexo());
    }


}
