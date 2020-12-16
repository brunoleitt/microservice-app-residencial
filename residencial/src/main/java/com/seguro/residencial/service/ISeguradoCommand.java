package com.seguro.residencial.service;

import com.seguro.residencial.domain.commands.cliente.RegistrarSeguradoCommand;

/**
 * @criado 15/12/2020 - 21:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ISeguradoCommand {

    void command(RegistrarSeguradoCommand command);

}
