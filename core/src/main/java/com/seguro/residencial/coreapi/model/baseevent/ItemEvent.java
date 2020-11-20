package com.seguro.residencial.coreapi.model.baseevent;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.AggregateIdentifier;

/**
 * @criado 07/11/2020 - 15:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class ItemEvent {

    @AggregateIdentifier
    private Long id;

    public ItemEvent(Long id) {
        this.id = id;
    }
}
