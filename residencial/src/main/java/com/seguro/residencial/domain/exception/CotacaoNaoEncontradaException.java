package com.seguro.residencial.domain.exception;

import java.text.MessageFormat;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class CotacaoNaoEncontradaException extends NegocioException {

    public CotacaoNaoEncontradaException(String mensagem) {
        super(MessageFormat.format("Não foi possivel encontrar o numero de cotação de id: {0}",mensagem));
    }
}
