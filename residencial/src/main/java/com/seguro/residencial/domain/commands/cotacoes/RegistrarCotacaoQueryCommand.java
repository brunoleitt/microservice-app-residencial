package com.seguro.residencial.domain.commands.cotacoes;

import com.seguro.residencial.coreapi.model.basecommand.CotacaoCommand;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * Realizar persistencia para consultar dados de cotacao em base de cash
 *
 *
 */
public class RegistrarCotacaoQueryCommand extends CotacaoCommand {

    public RegistrarCotacaoQueryCommand(Long id, String codigoCotacao) {
        super(id, codigoCotacao);
    }
}
