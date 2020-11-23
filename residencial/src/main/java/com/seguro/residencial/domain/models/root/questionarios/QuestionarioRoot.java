package com.seguro.residencial.domain.models.root.questionarios;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.Data;

import javax.persistence.*;

/**
 * @criado 22/10/2020 - 20:09
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "questionario")
public class QuestionarioRoot {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    private boolean possuiAntiFurto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCotacao", foreignKey = @ForeignKey(name = "fk_cotacaoQuestionario"))
    private CotacaoRoot cotacao;

}
