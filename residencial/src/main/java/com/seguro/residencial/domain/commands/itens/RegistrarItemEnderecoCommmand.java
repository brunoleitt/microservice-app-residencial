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

    public RegistrarItemEnderecoCommmand(Long id, Long idItemEndereco,
                                         String logradouro, String numero,
                                         String complemento, String cidade,
                                         String UF, String CEP) {
        super(id);
        this.idItemEndereco = idItemEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.UF = UF;
        this.CEP = CEP;
    }

    private Long idItemEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String UF;
    private String CEP;

}
