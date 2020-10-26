package com.seguro.residencial.domain.commands.cotacao;

import com.seguro.residencial.coreapi.model.basecommand.BaseCommand;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * Realizar persistencia para consultar dados de cotacao em base de cash
 *
 *
 */
public class CriacaoCotacaoQueryCommand extends BaseCommand {

    public final String titulo;

    public CriacaoCotacaoQueryCommand(Long id, String titulo) {
        super(id);
        this.titulo = titulo;
    }
}
