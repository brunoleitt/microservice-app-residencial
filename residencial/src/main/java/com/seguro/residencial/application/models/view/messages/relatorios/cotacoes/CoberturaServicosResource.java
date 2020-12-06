package com.seguro.residencial.application.models.view.messages.relatorios.cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @criado 05/12/2020 - 18:29
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoberturaServicosResource {
    private String descricao;
    private String detalheServicos;
    private String urlImagemServico;
}
