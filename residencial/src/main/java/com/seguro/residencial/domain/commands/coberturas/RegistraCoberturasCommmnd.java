package com.seguro.residencial.domain.commands.coberturas;

import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @criado 14/11/2020 - 06:27
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@NoArgsConstructor
@Getter
public class RegistraCoberturasCommmnd {

    private Long id;
    private String descricao;
    private TipoRisco tipoRisco;
    private ItemRoot item;
    private double premioBaseCotacao;
    private double premioLiquidoCotacao;

}
