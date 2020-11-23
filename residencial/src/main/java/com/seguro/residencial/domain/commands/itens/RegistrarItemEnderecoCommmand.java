package com.seguro.residencial.domain.commands.itens;

import com.seguro.residencial.coreapi.model.basecommand.ItemCommand;
import lombok.Getter;

/**
 * @criado 06/11/2020 - 19:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class RegistrarItemEnderecoCommmand extends ItemCommand {

    public RegistrarItemEnderecoCommmand(String id, String idItemEndereco,
                                         String logradouro, String numero,
                                         String complemento, String cidade,
                                         String uf, String cep) {
        super(id);
        this.idItemEndereco = idItemEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    private String idItemEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

}
