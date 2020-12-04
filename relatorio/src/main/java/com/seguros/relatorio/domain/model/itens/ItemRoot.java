package com.seguros.relatorio.domain.model.itens;

import com.seguros.relatorio.domain.model.coberturas.PacoteCoberturaRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 02/12/2020 - 09:49
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRoot {
    private String tipoRisco;
    private ItemEndereco itemEndereco;
    private PacoteCoberturaRoot pacoteCoberturaRoot;
}
