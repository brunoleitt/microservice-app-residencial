package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.models.input.cotacao.AtualizarStatusInput;
import com.seguro.residencial.application.models.input.cotacao.RegistrarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoRegistradaViewModel;

/**
 * @criado 12/10/2020 - 15:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoAppService {
    CotacaoRegistradaViewModel criacaoCotacao(RegistrarCotacaoInput criarCotacaoInput);
    void atualizarStatusCotacao(String codigoCotaocao, AtualizarStatusInput atualizarStatusInput);
}
