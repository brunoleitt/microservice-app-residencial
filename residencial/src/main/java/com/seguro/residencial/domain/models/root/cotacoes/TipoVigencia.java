package com.seguro.residencial.domain.models.root.cotacoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @criado 20/10/2020 - 14:26
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TipoVigencia")
public class TipoVigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;
}
