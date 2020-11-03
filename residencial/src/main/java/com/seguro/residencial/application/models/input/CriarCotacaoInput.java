package com.seguro.residencial.application.models.input;

import lombok.Getter;
import lombok.Setter;
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

    private Long idTipoCalculo;

    private Long idTipoVigencia;

    private LocalDate dataVigenciaInicial;

    public String codigoCotacao = UUID.randomUUID().toString();

    private LocalDate dataCotacao = LocalDate.now();

}
