package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.interfaces.repository.CustomJpaRepository;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import org.springframework.stereotype.Repository;

/**
 * @criado 25/10/2020 - 20:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ITipoCalculoRepository extends CustomJpaRepository<TipoCalculo, Long> {

}
