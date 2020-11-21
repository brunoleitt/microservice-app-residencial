package com.seguro.residencial.domain.models.root.clientes;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

//TODO Alterar o nome de todas as classes de Cliente para Segurado


/**
 * @criado 25/10/2020 - 11:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class ClienteRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfissao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_profissaoCliente"))
    private Profissao profissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSexo"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_sexoCliente"))
    private Sexo sexo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCotacao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cotacaoCliente"))
    private CotacaoRoot cotacao;

}
