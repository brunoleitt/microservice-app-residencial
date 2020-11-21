package com.seguro.residencial.application.interfaces.clientes;

import com.seguro.residencial.application.models.input.cliente.ClienteInput;

/**
 * @criado 21/11/2020 - 14:24
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

public interface IClienteAppService {
    void registrarCliente(ClienteInput input, String idCotacao);
}
