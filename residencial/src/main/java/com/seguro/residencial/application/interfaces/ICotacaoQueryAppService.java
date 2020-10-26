package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @criado 15/10/2020 - 23:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoQueryAppService {

    List<TipoCalculo> listarTipoCalculo();

    CompletableFuture<CotacaoRoot> listarTodos() throws ExecutionException, InterruptedException;

}
