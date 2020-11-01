package com.seguro.residencial.coreapi.model.basecommand;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class CotacaoCommand {

    @TargetAggregateIdentifier
    public Long id;

    public String codigoCotacao;

    private void IsValid() { }

    public CotacaoCommand(Long id, String codigoCotacao) {
        this.id = id;
        this.codigoCotacao = codigoCotacao;
    }
}
