package com.seguro.residencial.domain.exception.clientes;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 21/11/2020 - 14:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class ProfissaoNaoEncontradaException extends NegocioException {

    public ProfissaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ProfissaoNaoEncontradaException(Long idTipoProfissao) {
        this(String.format("Codigo tipo de profissao não encontrada para id: %d", idTipoProfissao));
    }



}
