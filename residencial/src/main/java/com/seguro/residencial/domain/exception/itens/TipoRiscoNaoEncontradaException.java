package com.seguro.residencial.domain.exception.itens;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class TipoRiscoNaoEncontradaException extends NegocioException {

    public TipoRiscoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public TipoRiscoNaoEncontradaException(Long idTipoRisco) {
        this(String.format("Codigo tipo de Tipo Risco não encontrado para id: %d", idTipoRisco));
    }

}
