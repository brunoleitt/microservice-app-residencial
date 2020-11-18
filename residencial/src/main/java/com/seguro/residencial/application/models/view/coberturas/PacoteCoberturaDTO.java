package com.seguro.residencial.application.models.view.coberturas;

import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @criado 17/11/2020 - 03:07
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacoteCoberturaDTO {
    private Long id;
    private String descricao;
    private Double premioBaseCotacao;
    private Double premioLiquidoCotacao;
    private TipoRisco tipoRisco;
    private List<CoberturasModel> coberturas;
}
