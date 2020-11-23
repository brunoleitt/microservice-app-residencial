package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.cotacoes.AtualizarStatusCotacaoCommand;
import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;
import com.seguro.residencial.domain.events.cotacoes.CotacaoStatusAtualizadaEvent;
import com.seguro.residencial.domain.events.cotacoes.RegistradaCotacaoEvent;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

/**
 * @criado 12/10/2020 - 14:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Aggregate
@NoArgsConstructor
public class CotacaoAggregate {

    @AggregateIdentifier
    private Long id;
    private String codigoCotacao;
    private LocalDate dataCotacao;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;
    private StatusCotacao statusCotacao;

    @CommandHandler
    public CotacaoAggregate(RegistrarCotacaoCommand createCotacaoCommand) {
        AggregateLifecycle.apply(new RegistradaCotacaoEvent(createCotacaoCommand.getId(),
                createCotacaoCommand.getCodigoCotacao(),
                createCotacaoCommand.getDataCotacao(),
                createCotacaoCommand.getDataVigenciaInicial(),
                createCotacaoCommand.getDataVigenciaFinal(),
                createCotacaoCommand.getTipoCalculo(),
                createCotacaoCommand.getTipoVigencia(),
                createCotacaoCommand.getStatus()));
    }

    @CommandHandler
    public void on(AtualizarStatusCotacaoCommand command) {
        AggregateLifecycle.apply(new CotacaoStatusAtualizadaEvent(command.getCodigoCotacao(),
                command.getStatusAnterior(), command.getStatusNovo()));
    }


    @EventSourcingHandler
    public void on(RegistradaCotacaoEvent event) {
        this.id = event.getId();
        this.codigoCotacao = event.getCodigoCotacao();
        this.dataCotacao = LocalDate.now();
        this.dataVigenciaInicial = event.getDataVigenciaInicial();
        this.dataVigenciaFinal = event.getDataVigenciaFinal();
        this.tipoCalculo = event.getTipoCalculo();
        this.tipoVigencia = event.getTipoVigencia();
        this.statusCotacao = event.getStatusCotacao();
    }
}
