package com.seguro.residencial.domain.events;

import com.seguro.residencial.coreapi.model.baseevent.CotacaoEvent;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @criado 12/10/2020 - 14:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 *
 * Contem todas as informações para criação da cotação
 *  - Propedidades com dados validar para realizar o mapeamento com entidade de modelo.
 *  - Propeidades com os dados necessario para cricao de uma nova contação
 */
@Getter
@Setter
public class CriadaCotacaoEvent extends CotacaoEvent {

    public CriadaCotacaoEvent(Long id,
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
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;
    }

    private LocalDate dataCotacao;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private TipoCalculo tipoCalculo;
    private TipoVigencia tipoVigencia;
    private ItemRoot item;
    private QuestionarioRoot questionario;
    private ClienteRoot cliente;

}
