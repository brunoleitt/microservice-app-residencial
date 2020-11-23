package com.seguro.residencial.application.models.input.cotacao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @criado 23/11/2020 - 13:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class AtualizarStatusInput {

    @ApiModelProperty(example = "CALCULADA", required = true)
    @NotNull
    private Long codigoStatusCotacao;
}
