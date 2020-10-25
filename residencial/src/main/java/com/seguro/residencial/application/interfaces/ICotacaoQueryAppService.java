package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 15/10/2020 - 23:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoQueryAppService {

    CompletableFuture<CotacaoRoot> findById(String idCotacao);

    List<Object> listEventsForAccount(String accountId);

}
