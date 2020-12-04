package com.seguros.relatorio.application.models.views.cotacoes;

import com.seguros.relatorio.application.models.views.itens.ItemViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 04/12/2020 - 09:34
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoViewModel {

    private String dataCotacao;
    private String dataVigenciaInicial;
    private String dataVigenciaFinal;
    private String tipoCalculo;
    private String tipoVigencia;
    private ItemViewModel item;

}
