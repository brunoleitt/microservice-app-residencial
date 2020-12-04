package com.seguros.relatorio.relatorio.domain.exception;

/**
 * @criado 04/12/2020 - 10:50
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class DocumentoNaoEncontradoException extends NegocioException {

    public DocumentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public DocumentoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
