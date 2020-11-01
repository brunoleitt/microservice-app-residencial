package com.seguro.residencial.coreapi.model.baseevent;

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
public class CotacaoEvent {

    @TargetAggregateIdentifier
    public final Long id;

    public CotacaoEvent(Long id) {
        this.id = id;
    }
}
