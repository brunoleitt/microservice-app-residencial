package com.seguro.residencial.domain.models.root.segurados;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;


/**
 * @criado 25/10/2020 - 11:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "segurado")
public class SeguradoRoot {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 30)
    private String sobreNome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 12)
    private String telefone;

    @Column(nullable = false, length = 10)
    private String rg;

    @Column(nullable = false, length = 30)
    private String email;

    private LocalDate dataNascimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfissao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_profissaoSegurado"))
    private Profissao profissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSexo"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_sexoSegurado"))
    private Sexo sexo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCotacao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cotacaoSegurado"))
    private CotacaoRoot cotacao;

}
