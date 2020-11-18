package com.seguro.residencial.domain.exception.coberturas;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class PacoteCoberturaTipoRiscoNaoEncontradaException extends NegocioException {


    public PacoteCoberturaTipoRiscoNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public PacoteCoberturaTipoRiscoNaoEncontradaException(Long idTipoCobertura, Long idTipoRisco) {
        this(String.format("Pacote de cobertura não encontrado para o id de Tipo Risco %s e " +
                "Codigo de Cobertura %s ", idTipoRisco, idTipoCobertura));
    }
}
