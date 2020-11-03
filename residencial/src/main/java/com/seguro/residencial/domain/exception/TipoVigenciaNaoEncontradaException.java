package com.seguro.residencial.domain.exception;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class TipoVigenciaNaoEncontradaException extends NegocioException {

    public TipoVigenciaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public TipoVigenciaNaoEncontradaException(Long idTipoVigencia) {
        this(String.format("Não existe um cadastro Tipo Vigencia com código de Id %d", idTipoVigencia));
    }
}
