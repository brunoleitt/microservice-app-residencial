package com.seguro.residencial.service;

import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;

/**
 * @criado 15/12/2020 - 21:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IItemCommand {

    void command(RegistrarItemCommand command);

}
