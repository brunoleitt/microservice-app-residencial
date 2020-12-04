package com.seguros.relatorio.relatorio.application.models.views.itens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 04/12/2020 - 09:36
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEnderecoViewModel {
    private String cep;
    private String cidade;
    private String complemento;
    private String logradouro;
    private String numero;
    private String uf;
}
