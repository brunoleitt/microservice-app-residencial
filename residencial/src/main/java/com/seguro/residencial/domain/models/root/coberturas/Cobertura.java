package com.seguro.residencial.domain.models.root.coberturas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @criado 23/10/2020 - 16:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cobertura")
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacote_cobertura",foreignKey = @ForeignKey(name = "fk_cobertura_pacote_cobertura"))
    private CoberturasPacoteRoot pacoteCoberturasRoot;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private Double valorImportanciaSegurada;

    @Column(nullable = false, length = 30)
    private String imagemCobertura;
}
