package com.seguro.residencial.domain.models.root.cotacoes;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 23/11/2020 - 13:48
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
public class StatusCotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;

}
