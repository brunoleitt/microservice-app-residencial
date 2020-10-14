package com.seguro.residencial.coreapi.model.baseevent;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class BaseEvent<T> {

    @TargetAggregateIdentifier
    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
