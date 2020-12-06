package com.seguros.relatorio.application.assembler.relatorios.cotacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @criado 05/12/2020 - 18:27
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoberturasResource {
    private String descricao;
    private Double valorImportanciaSegurada;
    private String imagemCobertura;
}
