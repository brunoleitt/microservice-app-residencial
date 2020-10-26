package com.seguro.residencial.coreapi.model.basecommand;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class BaseCommand {

    @TargetAggregateIdentifier
    public final Long id;

    public BaseCommand(Long id) {
        this.id = id;
    }
}
