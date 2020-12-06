package com.seguro.residencial.application.models.view.messages.relatorios.cotacoes;

import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @criado 05/12/2020 - 18:24
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResource {
    private CoberturasPacoteResouce cobertura;
    private TipoRisco tipoRisco;
    private ItemEnderecoResource enderecoItem;
}
