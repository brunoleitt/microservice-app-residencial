package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.cotacao.CriacaoCotacaoCommand;
import com.seguro.residencial.domain.events.CriacaoCotacaoEvent;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @criado 12/10/2020 - 14:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Aggregate
@Getter
@Setter
public class CotacaoAggregate {

    @AggregateIdentifier
    private String id;

    private String titulo;

    public CotacaoAggregate() {
    }

    @CommandHandler
    public CotacaoAggregate(CriacaoCotacaoCommand createCotacaoCommand){
        AggregateLifecycle.apply(new CriacaoCotacaoEvent(createCotacaoCommand.id, createCotacaoCommand.titulo));
    }

    @EventSourcingHandler
    protected void on(CriacaoCotacaoEvent criacaoCotacaoEvent){
        this.id = criacaoCotacaoEvent.id;
        this.titulo = criacaoCotacaoEvent.titulo;
    }

}
