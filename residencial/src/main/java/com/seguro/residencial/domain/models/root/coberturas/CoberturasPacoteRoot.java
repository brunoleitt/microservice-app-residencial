package com.seguro.residencial.domain.models.root.coberturas;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @criado 23/10/2020 - 16:56
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cobertura_pacote")
public class CoberturasPacoteRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false, length = 30)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "idTipoRisco"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cobertura_pacote_tipo_risco"))
    private TipoRisco tipoRisco;

    @NotNull
    private double premioBaseCotacao;

    @NotNull
    private double premioLiquidoCotacao;

    @OneToMany(mappedBy = "pacoteCoberturasRoot",fetch = FetchType.LAZY)
    private List<Cobertura> coberturas;
}
