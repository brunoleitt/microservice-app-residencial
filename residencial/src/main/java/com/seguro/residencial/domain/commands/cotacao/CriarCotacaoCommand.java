package com.seguro.residencial.domain.commands.cotacao;

import com.seguro.residencial.coreapi.model.basecommand.CotacaoCommand;
import com.seguro.residencial.domain.commands.validacao.CriarCotacaoCommandValidation;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 */

@Getter
@Setter
public class CriarCotacaoCommand extends CotacaoCommand {

    public CriarCotacaoCommand(Long id,
                               String codigoCotacao,
                               LocalDate dataCotacao,
                               LocalDate dataVigenciaInicial,
                               LocalDate dataVigenciaFinal,
                               TipoCalculo tipoCalculo,
                               TipoVigencia tipoVigencia,
                               ItemRoot item,
                               QuestionarioRoot questionario,
                               ClienteRoot cliente) {
        super(id,codigoCotacao);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;
        this.dataVigenciaFinal = calcularVigenciaFinal(tipoVigencia.getId());

        IsValid();
    }

        private LocalDate  dataCotacao;
        private LocalDate  dataVigenciaInicial;
        private LocalDate  dataVigenciaFinal;
        private TipoCalculo tipoCalculo;
        private TipoVigencia tipoVigencia;
        private ItemRoot item;
        private QuestionarioRoot questionario;
        private ClienteRoot cliente;


    void IsValid() {
        new CriarCotacaoCommandValidation(this).IsValid();
    }


    LocalDate calcularVigenciaFinal(Long idTipoVigencia){
        if (tipoVigencia.getId().equals(idTipoVigencia))
            return this.dataVigenciaInicial.plusYears(1);
        else
            return this.dataVigenciaInicial.plusYears(2);
    }

}
