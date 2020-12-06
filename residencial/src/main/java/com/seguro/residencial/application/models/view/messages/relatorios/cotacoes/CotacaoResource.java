package com.seguro.residencial.application.models.view.messages.relatorios.cotacoes;

import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @criado 05/12/2020 - 18:22
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoResource {
    private String codigoCotacao;
    private LocalDate dataCotacao;
    private LocalDate  dataVigenciaInicial;
    private LocalDate  dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;
    private StatusCotacao status;
    private ItemResource item;
    private SeguradoResource segurado;
}
