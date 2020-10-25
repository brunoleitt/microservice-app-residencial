package com.seguro.residencial.domain.models.root.cotacoes;


import com.seguro.residencial.domain.models.root.clientes.ClienteEndereco;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.*;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @criado 16/09/2020 - 00:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Entity
@Data
@Table(name = "cotacao")
public class CotacaoRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataCotacao;

    private OffsetDateTime dataVigenciaInicial;

    private OffsetDateTime dataVigenciaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoCalculo"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_calculo_cotacao"))
    private TipoCalculo tipoCalculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoVigencia"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_tipo_vigencia_cotacao"))
    private TipoVigencia tipoVigencia;

    @OneToOne(mappedBy = "cotacao")
    private ItemRoot item;

    @OneToOne(mappedBy = "cotacao")
    private QuestionarioRoot questionario;

    @OneToOne(mappedBy = "cotacao")
    private ClienteRoot cliente;

}
