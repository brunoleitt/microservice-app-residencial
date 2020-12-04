package com.seguros.relatorio.application.models.views.itens;

import com.seguros.relatorio.application.models.views.coberturas.CoberturasViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 04/12/2020 - 09:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemViewModel {

    private String tipoRisco;
    private ItemEnderecoViewModel itemEndereco;
    private CoberturasViewModel pacoteCoberturaRoot;

}
