package com.seguro.residencial.domain.models.root.clientes;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 21/11/2020 - 14:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "sexo")
public class Sexo {

    @Id
    private Long id;

    @Column(nullable = false, length = 10)
    private String descricao;

}
