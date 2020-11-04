package com.seguro.residencial.application.models.input.cotacao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @criado 12/10/2020 - 15:38
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 */
@Getter
@Setter
public class CriarCotacaoInput {

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long idTipoCalculo;

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long idTipoVigencia;

    @ApiModelProperty(example = "2020-11-04", required = true)
    @NotNull
    private LocalDate dataVigenciaInicial;
}
