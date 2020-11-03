package com.seguro.residencial.domain.exception;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class TipoCalculoNaoEncontradaException extends NegocioException {

    public TipoCalculoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public TipoCalculoNaoEncontradaException(Long idTipoCalculo) {
        this(String.format("Codigo tipo de calculo não encontrado para id: %d", idTipoCalculo));
    }

}
