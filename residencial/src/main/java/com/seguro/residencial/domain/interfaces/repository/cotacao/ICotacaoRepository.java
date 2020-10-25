package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @criado 12/10/2020 - 15:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ICotacaoRepository extends PagingAndSortingRepository<CotacaoRoot, String> {
}
