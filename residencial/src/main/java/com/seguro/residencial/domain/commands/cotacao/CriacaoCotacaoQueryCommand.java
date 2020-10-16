package com.seguro.residencial.domain.commands.cotacao;

import com.seguro.residencial.coreapi.model.basecommand.BaseCommand;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class CriacaoCotacaoQueryCommand extends BaseCommand<String> {

    public final String titulo;

    public CriacaoCotacaoQueryCommand(String id, String titulo) {
        super(id);
        this.titulo = titulo;
    }
}
