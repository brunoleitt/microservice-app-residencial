package com.seguro.residencial.application.models.input.item;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @criado 26/10/2020 - 17:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Getter
@Setter
@AllArgsConstructor
public class RegistrarItemInput {

    @ApiModelProperty(example = "1", required = true)
    @NotNull
    private Long idTipoRisco;

    @ApiModelProperty(example = "2", required = true)
    @NotNull
    private Long idPacoteCobertura;

    @ApiModelProperty(example = "Avenida Salim Farah Maluf", required = true)
    @NotNull
    private String logradouro;

    @ApiModelProperty(example = "999", required = true)
    @NotNull
    private String numero;

    @ApiModelProperty(example = "Apto 33", required = true)
    @NotNull
    private String complemento;

    @ApiModelProperty(example = "São Paulo", required = true)
    @NotNull
    private String cidade;

    @ApiModelProperty(example = "SP", required = true)
    @NotNull
    @Size(min=2, max=2)
    private String uf;

    @ApiModelProperty(example = "05734140", required = true)
    @NotNull
    @Size(min=8, max=8)
    private String cep;
}
