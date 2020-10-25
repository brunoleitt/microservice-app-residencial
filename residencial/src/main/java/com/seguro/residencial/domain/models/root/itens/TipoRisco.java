package com.seguro.residencial.domain.models.root.itens;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @criado 23/10/2020 - 13:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name="tipo_risco")
public class TipoRisco {

    @Id
    private Long idTipoRisco;

    @Column(nullable = false)
    private String descricao;
}
