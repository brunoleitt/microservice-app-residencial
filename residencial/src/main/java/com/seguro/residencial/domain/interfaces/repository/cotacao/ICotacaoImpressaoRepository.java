package com.seguro.residencial.domain.interfaces.repository.cotacao;

import com.seguro.residencial.application.models.view.messages.relatorios.cotacoes.CotacaoResource;

/**
 * @criado 05/12/2020 - 15:20
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoImpressaoRepository {
    CotacaoResource consultarCotacaoImpressao(String codigoCotacao);
}
