package com.seguros.relatorio.relatorio.domain.exception;

/**
 * @criado 04/12/2020 - 10:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class NegocioException extends RuntimeException {

    public NegocioException(String mensagem) {
        super(mensagem);
    }

    public NegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
