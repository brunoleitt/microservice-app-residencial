package com.seguro.residencial.domain.commands.validacoes.item;

import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import lombok.AllArgsConstructor;

/**
 * @criado 07/11/2020 - 15:58
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@AllArgsConstructor
public class RegistrarItemCommandValidation {

    private RegistrarItemCommand itemCommand;

    public final void IsValid() {

        //validaDataInicioVigencia();
    }
}
