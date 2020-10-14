package com.seguro.residencial.domain.models.root.cotacao;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @criado 16/09/2020 - 00:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "cotacao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cotacao {


    @Id
    @EqualsAndHashCode.Include
    private String id;


    @NotNull(message = "The field 'title' is mandatory")
    @Column(nullable = false)
    private String titulo;

    public Cotacao() {
    }
}
