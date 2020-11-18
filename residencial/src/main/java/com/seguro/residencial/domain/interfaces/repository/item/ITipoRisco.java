package com.seguro.residencial.domain.interfaces.repository.item;

import com.seguro.residencial.application.interfaces.ICustomJpaRepository;
import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import org.springframework.stereotype.Repository;

/**
 * @criado 14/11/2020 - 17:07
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ITipoRisco extends ICustomJpaRepository<TipoRisco, Long> {

}
