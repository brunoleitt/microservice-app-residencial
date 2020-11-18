package com.seguro.residencial.domain.exception.coberturas;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class PacoteCoberturaNaoEncontradaException extends NegocioException {

    public PacoteCoberturaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PacoteCoberturaNaoEncontradaException(Long idPacoteCobertura) {
        this(String.format("Codigo tipo de Tipo Cobertura não encontrado para id: %d", idPacoteCobertura));
    }

}
