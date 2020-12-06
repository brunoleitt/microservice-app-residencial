package com.seguro.residencial.application.models.view.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @criado 16/11/2020 - 20:20
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@AllArgsConstructor
public class CoberturasTipoRiscoModel {

    private String descricao;
    private String premioBase;
    private String premioLiquido;

    private List<CoberturasModel> coberturasModel;

}
