package com.seguro.residencial.domain.commands.cotacao;

import com.seguro.residencial.coreapi.model.basecommand.BaseCommand;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 */
@Getter
@Setter
public class CriarCotacaoCommand extends BaseCommand {

    public CriarCotacaoCommand(Long id,
                               OffsetDateTime dataCotacao,
                               OffsetDateTime dataVigenciaInicial,
                               OffsetDateTime dataVigenciaFinal,
                               Integer idTipoCalculo,
                               Integer idTipoVigencia,
                               ItemRoot item,
                               QuestionarioRoot questionario,
                               ClienteRoot cliente) {
        super(id);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.idTipoCalculo = idTipoCalculo;
        this.idTipoVigencia = idTipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;
    }

        private OffsetDateTime dataCotacao;

        private OffsetDateTime dataVigenciaInicial;

        private OffsetDateTime dataVigenciaFinal;

        private Integer idTipoCalculo;

        private Integer idTipoVigencia;

        private ItemRoot item;

        private QuestionarioRoot questionario;

        private ClienteRoot cliente;
}
