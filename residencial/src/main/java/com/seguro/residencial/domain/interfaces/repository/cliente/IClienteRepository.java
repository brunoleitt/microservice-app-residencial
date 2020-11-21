package com.seguro.residencial.domain.interfaces.repository.cliente;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;

/**
 * @criado 21/11/2020 - 12:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IClienteRepository extends CustomJpaRepository<ClienteRoot, Long> {
}
