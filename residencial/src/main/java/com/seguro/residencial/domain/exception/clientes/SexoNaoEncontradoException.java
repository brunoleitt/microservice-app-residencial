package com.seguro.residencial.domain.exception.clientes;

import com.seguro.residencial.domain.exception.NegocioException;

/**
 * @criado 21/11/2020 - 14:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class SexoNaoEncontradoException extends NegocioException {

    public SexoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public SexoNaoEncontradoException(Long idTipoSexo) {
        this(String.format("Codigo tipo de sexo não encontrada para id: %d", idTipoSexo));
    }



}
