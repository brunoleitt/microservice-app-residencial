package com.seguro.residencial.domain.commands.validacoes.cliente;

import com.seguro.residencial.domain.commands.cliente.RegistrarSeguradoCommand;
import com.seguro.residencial.domain.exception.NegocioException;

import java.time.LocalDate;

/**
 * @criado 21/11/2020 - 15:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class RegistrarClienteCommandValidation {

    public RegistrarSeguradoCommand clienteCommand;

    public RegistrarClienteCommandValidation(RegistrarSeguradoCommand command) {
        this.clienteCommand = command;
    }

    public final void IsValid(){
        validarSeguradoMaiorIdade();
    }

    public void validarSeguradoMaiorIdade(){
        int idadeSegurado = (LocalDate.now().getYear() - clienteCommand.getDataNascimento().getYear());
        if(idadeSegurado < 18)
            throw new NegocioException("Segurado não poder ser menor de idade.");
    }
}
