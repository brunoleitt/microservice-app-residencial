package com.seguro.residencial.domain.interfaces.repository.cliente;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.clientes.Sexo;

/**
 * @criado 21/11/2020 - 14:51
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ISexoRepository extends CustomJpaRepository<Sexo,Long> {
}
