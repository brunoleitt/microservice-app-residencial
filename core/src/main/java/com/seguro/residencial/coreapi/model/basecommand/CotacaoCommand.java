package com.seguro.residencial.coreapi.model.basecommand;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CotacaoCommand {

    @TargetAggregateIdentifier
    public Long id;

    private String codigoCotacao;

    public CotacaoCommand(Long id, String codigoCotacao) {
        this.id = id;
        this.codigoCotacao = codigoCotacao;
    }
}
