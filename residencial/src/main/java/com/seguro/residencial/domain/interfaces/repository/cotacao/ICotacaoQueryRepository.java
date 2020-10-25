package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoQuery;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @criado 12/10/2020 - 15:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoQueryRepository extends PagingAndSortingRepository<CotacaoQuery, String> {
}
