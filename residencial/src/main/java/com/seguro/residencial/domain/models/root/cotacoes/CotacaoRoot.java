package com.seguro.residencial.domain.models.root.cotacoes;


import com.fasterxml.jackson.annotation.*;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import com.seguro.residencial.domain.models.root.segurados.SeguradoRoot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@Table(name = "cotacao")
@NoArgsConstructor
public class CotacaoRoot {

    @Id
    @Column(updatable = false, nullable = false, unique=true)
    private String codigoCotacao;

    private LocalDate dataCotacao;

    private LocalDate  dataVigenciaInicial;

    private LocalDate  dataVigenciaFinal;

    @CreationTimestamp
    private OffsetDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoCalculo"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_calculo_cotacao"))
    @JsonIgnore
    private TipoCalculo tipoCalculo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoVigencia"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_vigencia_cotacao"))
    @JsonIgnore
    private TipoVigencia tipoVigencia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idStatusCotacao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_status_cotacao"))
    @JsonIgnore
    private StatusCotacao status;

//    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
//    @JsonIgnoreProperties
//    private ItemRoot item;

//    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
//    private QuestionarioRoot questionario;

//    @OneToOne(mappedBy = "cotacao",fetch = FetchType.LAZY)
//    private SeguradoRoot segurado;


    public CotacaoRoot(String codigoCotacao, StatusCotacao status,
                       LocalDate dataCotacao, LocalDate dataVigenciaInicial,
                       LocalDate dataVigenciaFinal,
                       TipoCalculo tipoCalculo, TipoVigencia tipoVigencia) {

        this.codigoCotacao = codigoCotacao;
        this.status = status;
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.tipoCalculo = tipoCalculo;
        this.tipoVigencia = tipoVigencia;
    }
}
