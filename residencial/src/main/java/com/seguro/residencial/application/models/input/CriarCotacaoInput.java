package com.seguro.residencial.application.models.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 12/10/2020 - 15:38
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 */
@Getter
@Setter
public class CriarCotacaoInput {

    private Long idTipoCalculo;

    private Long idTipoVigencia;

    private LocalDate dataVigenciaInicial;

    private LocalDate dataVigenciaFinal;


}
