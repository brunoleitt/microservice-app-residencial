package com.seguro.residencial.domain.models.root.cotacoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 16/09/2020 - 00:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Entity
@Data
@Table(name = "cotacao")
public class CotacaoRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(updatable = false, nullable = false, unique=true)
    private String codigoCotacao;

    @Column(length = 30)
    private String statusCotacao;

    private LocalDate dataCotacao;

    private LocalDate  dataVigenciaInicial;

    private LocalDate  dataVigenciaFinal;

    @CreationTimestamp
    private OffsetDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoCalculo"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_calculo_cotacao"))
    @JsonIgnore
    private TipoCalculo tipoCalculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoVigencia"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_vigencia_cotacao"))
    @JsonIgnore
    private TipoVigencia tipoVigencia;

    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
    private ItemRoot item;

    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
    private QuestionarioRoot questionario;

    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
    private ClienteRoot cliente;


    public CotacaoRoot(String codigoCotacao, String statusCotacao,
                       LocalDate dataCotacao, LocalDate dataVigenciaInicial,
                       LocalDate dataVigenciaFinal,
                       TipoCalculo tipoCalculo, TipoVigencia tipoVigencia,
                       ItemRoot item, QuestionarioRoot questionario,
                       ClienteRoot cliente) {

        this.codigoCotacao = codigoCotacao;
        this.statusCotacao = statusCotacao;
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;
    }

    public CotacaoRoot() {
    }
}
