package com.seguro.residencial.domain.exception;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class CotacaoNaoEncontradaException extends NegocioException {

    public CotacaoNaoEncontradaException(String mensagem) {
        super("Não foi possivel encontrar o numero de cotação de id:".concat(mensagem));
    }
}
