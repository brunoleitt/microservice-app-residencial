package com.seguro.residencial.domain.models.root.itens;

import com.seguro.residencial.domain.models.root.coberturas.CoberturasPacoteRoot;
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
    @Column(name = "id", length = 50)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cotacao", referencedColumnName="codigoCotacao"
            , foreignKey = @ForeignKey(name = "fk_cotacaoItem"))
    private CotacaoRoot cotacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacote_cobertura", referencedColumnName="id"
            , foreignKey = @ForeignKey(name = "fk_pacoteCobertura"))
    private CoberturasPacoteRoot cobertura;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_risco", referencedColumnName="id"
            , foreignKey = @ForeignKey(name = "fk_tipoRisco"))
    private TipoRisco tipoRisco;

    @OneToOne(mappedBy = "item",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ItemEndereco enderecoItem;

}
