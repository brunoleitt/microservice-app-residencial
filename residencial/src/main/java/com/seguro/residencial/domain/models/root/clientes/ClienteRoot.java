package com.seguro.residencial.domain.models.root.clientes;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @criado 25/10/2020 - 11:45
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "cliente")
public class ClienteRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 10)
    private String nome;

    @Column(nullable = false, length = 10)
    private String sobreNome;

    @Column(nullable = false, length = 10)
    private Long CPF;

    @Column(nullable = false, length = 10)
    private String telefone;

    @Column(nullable = false, length = 10)
    private String RG;

    @Column(nullable = false, length = 30)
    private String email;

    private OffsetDateTime dataNascimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfissao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_profissaoCliente"))
    private Profissao profissao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCotacao"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cotacaoCliente"))
    private CotacaoRoot cotacao;


    @OneToOne(mappedBy = "cliente")
    private ClienteEndereco clienteEndereco;

}
