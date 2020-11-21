package com.seguro.residencial.domain.models.root.clientes;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 24/10/2020 - 21:06
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "profissao")
public class Profissao {
    @Id
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;

}
