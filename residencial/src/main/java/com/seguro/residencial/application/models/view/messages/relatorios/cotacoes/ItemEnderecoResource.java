package com.seguro.residencial.application.models.view.messages.relatorios.cotacoes;

import lombok.*;

/**
 * @criado 05/12/2020 - 18:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEnderecoResource {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
}
