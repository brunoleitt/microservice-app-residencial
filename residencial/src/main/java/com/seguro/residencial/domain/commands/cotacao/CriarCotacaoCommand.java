package com.seguro.residencial.domain.commands.cotacao;

import com.seguro.residencial.coreapi.model.basecommand.CotacaoCommand;
import com.seguro.residencial.domain.commands.validacao.CriarCotacaoCommandValidation;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
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
                               LocalDate  dataVigenciaInicial,
                               LocalDate  dataVigenciaFinal,
                               Long idTipoCalculo,
                               Long idTipoVigencia,
                               ItemRoot item,
                               QuestionarioRoot questionario,
                               ClienteRoot cliente) {
        super(id,codigoCotacao);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.idTipoCalculo = idTipoCalculo;
        this.idTipoVigencia = idTipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;

        this.IsValid();

    }

        void IsValid() {
            new CriarCotacaoCommandValidation(this).IsValid();
        }

        private LocalDate  dataCotacao;

        private LocalDate  dataVigenciaInicial;

        private LocalDate  dataVigenciaFinal;

        private Long idTipoCalculo;

        private Long idTipoVigencia;

        private ItemRoot item;

        private QuestionarioRoot questionario;

        private ClienteRoot cliente;
}
