package com.seguro.residencial.domain.exception.coberturas;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 29/10/2020 - 16:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class ServicosCoberturaTipoRiscoNaoEncontradaException extends NegocioException {


    public ServicosCoberturaTipoRiscoNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public ServicosCoberturaTipoRiscoNaoEncontradaException(Long idTipoCobertura, Long idTipoRisco) {
        this(String.format("Pacote de serviços não encontrado para o id de Tipo Risco %s e " +
                "Codigo de Cobertura %s ", idTipoRisco, idTipoCobertura));
    }
}
