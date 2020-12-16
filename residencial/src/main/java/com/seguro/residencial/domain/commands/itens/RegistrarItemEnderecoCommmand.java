package com.seguro.residencial.domain.commands.itens;

import lombok.Getter;

/**
 * @criado 06/11/2020 - 19:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class RegistrarItemEnderecoCommmand {

    public RegistrarItemEnderecoCommmand(String id, String idItemEndereco,
                                         String logradouro, String numero,
                                         String complemento, String cidade,
                                         String uf, String cep) {
        this.id = id;
        this.idItemEndereco = idItemEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    private String id;
    private String idItemEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

}
