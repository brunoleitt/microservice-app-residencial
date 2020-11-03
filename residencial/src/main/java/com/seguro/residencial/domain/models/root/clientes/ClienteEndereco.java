package com.seguro.residencial.domain.models.root.clientes;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 25/10/2020 - 11:49
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "cliente_endereco")
public class ClienteEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String Logradouro;

    @Column(nullable = false, length = 5)
    private String numero;

    @Column(nullable = false, length = 30)
    private String complemento;

    @Column(nullable = false, length = 10)
    private String bairro;

    @Column(nullable = false)
    private Integer CEP;

    @Column(nullable = false, length = 10)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String UF;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_cliente_clienteEndereco"))
    private ClienteRoot cliente;
}
