package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.viewmodels.CriarCotacaoViewModel;

import java.util.concurrent.CompletableFuture;

/**
 * @criado 12/10/2020 - 15:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoAppService {

    CompletableFuture<String> criacaoCotacao(CriarCotacaoViewModel criarCotacaoViewModel);

}
