package com.seguro.residencial.domain.commands.cotacoes;

import com.seguro.residencial.coreapi.model.basecommand.CotacaoCommand;
import com.seguro.residencial.domain.commands.validacoes.cotacao.RegistrarCotacaoCommandValidation;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class RegistrarCotacaoCommand extends CotacaoCommand {

    private final int anual = 1;
    private final int bianual = 2;

    public RegistrarCotacaoCommand(Long id,
                                   String codigoCotacao,
                                   LocalDate dataCotacao,
                                   LocalDate dataVigenciaInicial,
                                   TipoCalculo tipoCalculo,
                                   TipoVigencia tipoVigencia,
                                   StatusCotacao status) {
        super(id, codigoCotacao);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
        this.dataVigenciaFinal = calcularVigenciaFinal(tipoVigencia.getId());
        this.status = status;
        isValid();
    }

    private LocalDate dataCotacao;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;
    private StatusCotacao status;

    void isValid() {
        new RegistrarCotacaoCommandValidation(this).IsValid();
    }


    LocalDate calcularVigenciaFinal(Long idTipoVigenciaAnualBianual) {
        if (tipoVigencia.getId().equals(idTipoVigenciaAnualBianual))
            return this.dataVigenciaInicial.plusYears(anual);
        else
            return this.dataVigenciaInicial.plusYears(bianual);
    }

}
