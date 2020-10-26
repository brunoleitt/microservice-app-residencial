package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @criado 25/10/2020 - 20:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ITipoCalculoRepository extends JpaRepository<TipoCalculo, Long> {

}
