package com.seguro.residencial.domain.exception;

/**
 * @criado 30/10/2020 - 19:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class EntidadeEmUsoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
