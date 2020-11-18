package com.seguro.residencial.domain.commands.itens;

import com.seguro.residencial.coreapi.model.basecommand.ItemCommand;
import com.seguro.residencial.domain.commands.validacoes.item.RegistrarItemCommandValidation;
import com.seguro.residencial.domain.models.root.coberturas.CoberturasPacoteRoot;
import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.Getter;

/**
 * @criado 05/11/2020 - 19:36
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class RegistrarItemCommand extends ItemCommand {

    public RegistrarItemCommand(Long idItem, TipoRisco tipoRisco,
                                CoberturasPacoteRoot coberturasPacoteRoot,
                                Long idCotacao, String logradouro,
                                String numero, String complemento,
                                String cidade, String uf,
                                String cep) {
        super(idItem);
        this.idCotacao = idCotacao;
        this.tipoRisco = tipoRisco;
        this.coberturasPacoteRoot = coberturasPacoteRoot;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    private Long idCotacao;
    private TipoRisco tipoRisco;
    private CoberturasPacoteRoot coberturasPacoteRoot;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

    void IsValid() {
        new RegistrarItemCommandValidation(this).IsValid();
    }
}
