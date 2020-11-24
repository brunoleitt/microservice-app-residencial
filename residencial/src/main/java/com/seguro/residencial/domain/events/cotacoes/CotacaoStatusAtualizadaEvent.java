package com.seguro.residencial.domain.events.cotacoes;

import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @criado 23/11/2020 - 11:08
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@AllArgsConstructor
public class CotacaoStatusAtualizadaEvent {

    private String codigoCotacao;
    private StatusCotacao status;

}
