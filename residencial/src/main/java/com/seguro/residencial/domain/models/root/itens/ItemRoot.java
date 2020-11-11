package com.seguro.residencial.domain.models.root.itens;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.Data;

import javax.persistence.*;

/**
 * @criado 23/10/2020 - 13:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "item")
public class ItemRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cotacao", referencedColumnName="id"
            , foreignKey = @ForeignKey(name = "fk_cotacaoItem"))
    private CotacaoRoot cotacao;

    @OneToOne(mappedBy = "item",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ItemEndereco enderecoItem;
}
