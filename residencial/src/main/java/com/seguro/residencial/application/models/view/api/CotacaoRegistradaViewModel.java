package com.seguro.residencial.application.models.view.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @criado 29/10/2020 - 15:34
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CotacaoRegistradaViewModel {

    public CotacaoRegistradaViewModel(String codigoCotacao) {
        this.codigoCotacao = codigoCotacao;
    }

    @ApiModelProperty(example = "5dcfce1b-56e7-4d25-aa30-a6c896b9dcca")
    private String codigoCotacao;
}
