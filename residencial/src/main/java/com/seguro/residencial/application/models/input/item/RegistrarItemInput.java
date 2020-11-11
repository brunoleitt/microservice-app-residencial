package com.seguro.residencial.application.models.input.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @criado 26/10/2020 - 17:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Getter
@AllArgsConstructor
public class RegistrarItemInput {
    private String codigoCotacao;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
}
