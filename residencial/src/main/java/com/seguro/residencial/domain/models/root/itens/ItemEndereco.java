package com.seguro.residencial.domain.models.root.itens;

import lombok.Data;

import javax.persistence.*;

/**
 * @criado 23/10/2020 - 13:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Entity
@Data
@Table(name = "item_endereco")
public class ItemEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idItem"
            ,foreignKey = @ForeignKey(name = "FK_item_itemEndereco"))
    private ItemRoot item;

    @Column(nullable = false, length = 30)
    private String Logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 30)
    private String complemento;

    @Column(nullable = false, length = 20)
    private String Cidade;

    @Column(nullable = false, length = 2)
    private String UF;

    @Column(nullable = false, length = 5)
    private String CEP;
}
