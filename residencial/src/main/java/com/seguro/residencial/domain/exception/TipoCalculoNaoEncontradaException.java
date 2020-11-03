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
        this(String.format("Não existe um cadastro Tipo Calculo com código de Id %d", idTipoCalculo));
    }

}
