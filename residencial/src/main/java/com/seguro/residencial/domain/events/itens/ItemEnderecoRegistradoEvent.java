package com.seguro.residencial.domain.events.itens;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @criado 07/11/2020 - 15:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class ItemEnderecoRegistradoEvent {

    private Long id;
    private Long idItem;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String UF;
    private String CEP;

}
