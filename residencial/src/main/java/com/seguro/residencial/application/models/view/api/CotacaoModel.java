package com.seguro.residencial.application.models.view.api;

import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @criado 02/11/2020 - 23:56
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CotacaoModel {

    @ApiModelProperty(example = "5dcfce1b-56e7-4d25-aa30-a6c896b9dcca")
    private String codigoCotacao;

    @ApiModelProperty(example = "CRIADA")
    private String statusCotacao;

    @ApiModelProperty(example = "2020-11-04")
    private LocalDate  dataVigenciaInicial;

    @ApiModelProperty(example = "2020-11-04")
    private LocalDate  dataVigenciaFinal;

    @ApiModelProperty(example = "1")
    private TipoCalculo tipoCalculo;

    @ApiModelProperty(example = "1")
    private TipoVigencia tipoVigencia;

}
