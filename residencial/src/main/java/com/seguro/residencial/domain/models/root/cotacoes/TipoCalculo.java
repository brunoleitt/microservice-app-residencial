package com.seguro.residencial.domain.models.root.cotacoes;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 20/10/2020 - 14:26
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
public class TipoCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;
}
