package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;

/**
 * @criado 12/10/2020 - 15:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoAppService {
    CotacaoCriadaViewModel criacaoCotacao(CriarCotacaoInput criarCotacaoInput);
}
