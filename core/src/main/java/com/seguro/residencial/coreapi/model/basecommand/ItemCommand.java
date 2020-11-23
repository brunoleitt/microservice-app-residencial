package com.seguro.residencial.coreapi.model.basecommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @criado 07/11/2020 - 15:48
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Getter
@AllArgsConstructor
public class ItemCommand {

    @TargetAggregateIdentifier
    public String id;

}
