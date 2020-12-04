package com.seguros.relatorio.relatorio.application.interfaces;

import com.seguros.relatorio.relatorio.application.models.views.cotacoes.CotacaoViewModel;
import com.seguros.relatorio.relatorio.domain.model.cotacoes.Cotacao;

/**
 * @criado 02/12/2020 - 10:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IImpressaoAppService {
    CotacaoViewModel consultaCotacao(String codigoCotacao);
    Cotacao registrarImpressaoCotacao(Cotacao cotacao);
}
