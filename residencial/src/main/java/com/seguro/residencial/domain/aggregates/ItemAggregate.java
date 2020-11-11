package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import com.seguro.residencial.domain.commands.itens.RegistrarItemEnderecoCommmand;
import com.seguro.residencial.domain.events.itens.ItemEnderecoRegistradoEvent;
import com.seguro.residencial.domain.events.itens.ItemRegistradoEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @criado 05/11/2020 - 19:17
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Aggregate
@NoArgsConstructor
@Getter
public class ItemAggregate {


    @AggregateIdentifier
    private Long id;
    private Long idCotacao;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;


    @CommandHandler
    public ItemAggregate(RegistrarItemCommand command) {
        AggregateLifecycle.apply(new ItemRegistradoEvent(command.getIdItem(), command.getIdCotacao(),
                command.getLogradouro(), command.getNumero(),
                command.getComplemento(), command.getCidade(),
                command.getUf(), command.getCep()));
    }

//    @CommandHandler
//    public void handle(RegistrarItemEnderecoCommmand command) {
//        AggregateLifecycle.apply(new ItemEnderecoRegistradoEvent(command.getIdItemEndereco(),
//                command.getIdItem(),
//                command.getLogradouro(),
//                command.getNumero(),
//                command.getComplemento(),
//                command.getCidade(),
//                command.getUF(),
//                command.getCEP()));
//    }

    @EventSourcingHandler
    protected void on(ItemRegistradoEvent event) {
        this.id = event.getId();
        this.idCotacao = event.getIdCotacao();
        this.logradouro = event.getLogradouro();
        this.numero = event.getNumero();
        this.complemento = event.getComplemento();
        this.cidade = event.getCidade();
        this.uf = event.getUf();
        this.cep = event.getCep();
    }
}
