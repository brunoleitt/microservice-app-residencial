package com.seguro.residencial.domain.interfaces.repository.cliente;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.clientes.Profissao;

/**
 * @criado 21/11/2020 - 14:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IProfissaoRepository extends CustomJpaRepository<Profissao,Long> {

}
