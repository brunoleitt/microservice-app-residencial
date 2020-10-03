package com.seguro.core.repository;

import com.seguro.core.model.Cotacao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @criado 16/09/2020 - 15:55
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface CotacaoRepository extends PagingAndSortingRepository<Cotacao, Long> {
}
