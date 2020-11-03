package com.seguro.residencial.application.models.view;

import lombok.Getter;
import lombok.Setter;

/**
 * @criado 29/10/2020 - 15:34
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CotacaoCriadaViewModel {

    public CotacaoCriadaViewModel(String codigoCotacao) {
        this.codigoCotacao = codigoCotacao;
    }

    private String codigoCotacao;
}
