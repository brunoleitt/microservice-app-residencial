package com.seguros.relatorio.relatorio.application.interfaces;

import com.seguros.relatorio.relatorio.domain.model.cotacoes.Cotacao;
import org.springframework.stereotype.Service;

/**
 * @criado 02/12/2020 - 10:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IImpressaoAppService {
    Cotacao consultaCotacao(String codigoCotacao);
    Cotacao registrarImpressaoCotacao(Cotacao cotacao);
}
