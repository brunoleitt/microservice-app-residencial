package com.seguro.residencial.domain.models.root.itens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @criado 23/10/2020 - 13:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 30)
    private String complemento;

    @Column(nullable = false, length = 20)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 5)
    private String cep;
}
