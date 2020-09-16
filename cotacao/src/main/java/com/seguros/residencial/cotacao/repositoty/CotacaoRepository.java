package com.seguros.residencial.cotacao.repositoty;

import com.seguros.residencial.cotacao.model.Cotacao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @criado 16/09/2020 - 00:34
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface CotacaoRepository extends PagingAndSortingRepository<Cotacao, Long> {
}
