package com.seguro.residencial.application.models.view.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @criado 16/11/2020 - 21:15
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicosModel {
    private Long idCoberturasServicos;
    private String descricao;
    private String detalheServicos;
    private String urlImagemServico;
}
