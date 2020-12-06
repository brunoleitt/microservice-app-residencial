package com.seguros.relatorio.application.interfaces;

import com.seguros.relatorio.application.assembler.relatorios.cotacoes.Cotacao;
import com.seguros.relatorio.application.models.views.cotacoes.CotacaoViewModel;
import com.seguros.relatorio.domain.model.cotacoes.CotacaoOld;

/**
 * @criado 02/12/2020 - 10:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IImpressaoAppService {
    Cotacao consultaCotacao(String codigoCotacao);
    Cotacao registrarImpressaoCotacao(Cotacao cotacao);
}
