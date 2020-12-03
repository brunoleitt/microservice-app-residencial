package com.seguros.relatorio.relatorio.domain.repository;

import com.seguros.relatorio.relatorio.domain.model.cotacoes.Cotacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @criado 02/12/2020 - 10:49
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Repository
public interface ICotacaoRepository extends MongoRepository<Cotacao, String> {
}
