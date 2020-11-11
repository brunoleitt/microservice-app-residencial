package com.seguro.residencial.coreapi.model.baseevent;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @criado 12/10/2020 - 04:04
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class CotacaoEvent {
    private final Long id;
    private String codigoCotacao;
}
