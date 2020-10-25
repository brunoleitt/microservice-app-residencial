package com.seguro.residencial.domain.models.root.coberturas;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 23/10/2020 - 16:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Entity
@Data
@Table(name = "cobertura")
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pacote_cobertura"
            , insertable = false
            , updatable = false
            , foreignKey = @ForeignKey(name = "fk_cobertura_pacote_cobertura"))
    private CoberturasPacoteRoot pacoteCoberturasRoot;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private Double valorImportanciaSegurada;

    @Column(nullable = false, length = 30)
    private String imagemCobertura;
}
