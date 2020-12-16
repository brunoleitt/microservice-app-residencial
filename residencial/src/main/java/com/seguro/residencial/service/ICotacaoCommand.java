package com.seguro.residencial.service;

import com.seguro.residencial.domain.commands.cotacoes.AtualizarStatusCotacaoCommand;
import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;

/**
 * @criado 15/12/2020 - 19:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoCommand {

    void command(RegistrarCotacaoCommand registrarCotacaoCommand);

    void command(AtualizarStatusCotacaoCommand atualizarStatusCotacaoCommand);

}
