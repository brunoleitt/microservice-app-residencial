package com.seguro.residencial.coreapi.model.basecommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@ToString
@AllArgsConstructor
public class CotacaoCommand {

    @TargetAggregateIdentifier
    private Long id;
    private String codigoCotacao;

}
