package com.seguros.relatorio.application.models.views.coberturas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @criado 04/12/2020 - 09:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoberturasViewModel {

    private String descricaoPacoteCobertura;
    private String premioBaseCotacao;
    private String premioLiquidoCotacao;
    // TODO realizar o retorno de coberturas  private List<Coberturas> coberturas;
    private List<CoberturasServicosViewModel> coberturasServicos;

}
