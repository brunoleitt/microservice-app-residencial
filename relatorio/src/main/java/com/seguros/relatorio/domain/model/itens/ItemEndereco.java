package com.seguros.relatorio.domain.model.itens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 02/12/2020 - 09:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEndereco {

    private String cep;
    private String cidade;
    private String complemento;
    private String logradouro;
    private String numero;
    private String uf;

}
