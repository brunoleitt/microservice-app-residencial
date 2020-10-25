package com.seguro.residencial.domain.models.root.coberturas;

import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @criado 23/10/2020 - 16:56
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoRisco"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cobertura_pacote_tipo_risco"))
    private TipoRisco tipoRisco;

    @NotNull
    private double premioBaseCotacao;

    @NotNull
    private double premioLiquidoCotacao;

    @OneToMany
    @JoinColumn(name = "id_pacote_cobertura")
    private Set<Cobertura> coberturas;

    @OneToMany
    @JoinColumn(name = "id_pacote_cobertura")
    private Set<CoberturaServicos> coberturasServicos;

}
