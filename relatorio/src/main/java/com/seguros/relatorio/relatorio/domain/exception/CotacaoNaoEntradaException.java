package com.seguros.relatorio.relatorio.domain.exception;

import java.text.MessageFormat;

/**
 * @criado 04/12/2020 - 10:54
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class CotacaoNaoEntradaException extends NegocioException {

    public CotacaoNaoEntradaException(String codigoCotacao) {
        super(MessageFormat.format("Não foi encontrado a cotação de código:{0}", codigoCotacao));
    }
}
