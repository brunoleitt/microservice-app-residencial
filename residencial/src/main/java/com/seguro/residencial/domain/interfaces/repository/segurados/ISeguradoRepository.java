package com.seguro.residencial.domain.interfaces.repository.segurados;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.segurados.SeguradoRoot;

/**
 * @criado 21/11/2020 - 12:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ISeguradoRepository extends CustomJpaRepository<SeguradoRoot, Long> {
}
