package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.events.CriadaCotacaoEvent;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class CotacaoAggregate {

    @AggregateIdentifier
    private Long id;
    private String codigoCotacao;
    private LocalDate dataCotacao;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;

    @CommandHandler
    public CotacaoAggregate(CriarCotacaoCommand createCotacaoCommand){
          AggregateLifecycle.apply(new CriadaCotacaoEvent(createCotacaoCommand.id,
                                                           createCotacaoCommand.getCodigoCotacao(),
                                                           createCotacaoCommand.getDataCotacao(),
                                                           createCotacaoCommand.getDataVigenciaInicial(),
                                                           createCotacaoCommand.getDataVigenciaFinal(),
                                                           createCotacaoCommand.getTipoCalculo(),
                                                           createCotacaoCommand.getTipoVigencia()));
    }

    @EventSourcingHandler
    protected void criadaCotacaoEvent(CriadaCotacaoEvent event){
        this.id = event.getId();
        this.codigoCotacao = event.getCodigoCotacao();
        this.dataCotacao = LocalDate.now();
        this.dataVigenciaInicial = event.getDataVigenciaInicial();
        this.dataVigenciaFinal = event.getDataVigenciaFinal();
        this.tipoCalculo = event.getTipoCalculo();
        this.tipoVigencia = event.getTipoVigencia();
    }
}
