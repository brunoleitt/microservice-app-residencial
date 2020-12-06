package com.seguros.relatorio.application.assembler.relatorios.cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @criado 05/12/2020 - 18:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoberturasPacoteResouce {

    private Long id;
    private String descricao;
    private double premioBaseCotacao;
    private double premioLiquidoCotacao;
    private List<CoberturasResource> coberturas;
    private List<CoberturaServicosResource> coberturaServicos;

}
