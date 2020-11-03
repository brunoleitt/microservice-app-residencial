package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;

/**
 * @criado 02/11/2020 - 19:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ITipoVigenciaRepository extends CustomJpaRepository<TipoVigencia, Long> {
}
