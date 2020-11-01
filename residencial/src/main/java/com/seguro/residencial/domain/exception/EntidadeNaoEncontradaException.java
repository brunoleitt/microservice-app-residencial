package com.seguro.residencial.domain.exception;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
