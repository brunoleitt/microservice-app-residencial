package com.seguro.residencial.domain.models.root.coberturas;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @criado 23/10/2020 - 16:50
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "cobertura_servicos")
public class CoberturaServicos {

    @Id
    private Long idCoberturasServicos;

    @ManyToOne
    @JoinColumn(name = "id_pacote_cobertura"
            , insertable = false
            , updatable = false
            , foreignKey = @ForeignKey(name = "fk_cobertura_pacote_cobertura_serv"))
    private CoberturasPacoteRoot pacoteCoberturasRoot;


    @NotNull
    @Column(nullable = false, length = 30)
    private String descricao;

    @NotNull
    @Column(nullable = false, length = 300)
    private String detalheServicos;

    @NotNull
    @Column(nullable = false, length = 100)
    private String urlImagemServico;
}
