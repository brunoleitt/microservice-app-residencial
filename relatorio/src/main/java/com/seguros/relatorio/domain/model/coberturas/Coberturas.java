package com.seguros.relatorio.domain.model.coberturas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 02/12/2020 - 10:31
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coberturas {
    private String descricao;
    private String valorImportanciaSegurado;
}
