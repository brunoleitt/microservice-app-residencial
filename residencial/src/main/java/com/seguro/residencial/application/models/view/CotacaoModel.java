package com.seguro.residencial.application.models.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * @criado 02/11/2020 - 23:56
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CotacaoModel {

    private String codigoCotacao;

    private String statusCotacao;

    private LocalDate  dataVigenciaInicial;

    private LocalDate  dataVigenciaFinal;

    private TipoCalculo tipoCalculo;

    private TipoVigencia tipoVigencia;

}
