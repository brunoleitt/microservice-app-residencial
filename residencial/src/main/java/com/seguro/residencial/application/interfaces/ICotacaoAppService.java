package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 12/10/2020 - 15:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoAppService {
    CotacaoCriadaViewModel criacaoCotacao(CriarCotacaoInput criarCotacaoInput);
}
