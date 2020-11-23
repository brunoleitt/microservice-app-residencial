package com.seguro.residencial.domain.events.cotacoes;

import com.seguro.residencial.coreapi.model.baseevent.CotacaoEvent;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @criado 12/10/2020 - 14:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@ToString
public class RegistradaCotacaoEvent extends CotacaoEvent {

    public RegistradaCotacaoEvent(Long id,
                                  String codigoCotacao,
                                  LocalDate dataCotacao,
                                  LocalDate dataVigenciaInicial,
                                  LocalDate dataVigenciaFinal,
                                  TipoCalculo tipoCalculo,
                                  TipoVigencia tipoVigencia,
                                  StatusCotacao statusCotacao) {
        super(id,codigoCotacao);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
        this.statusCotacao = statusCotacao;
    }

    private LocalDate dataCotacao;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;
    private StatusCotacao statusCotacao;

}
