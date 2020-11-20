package com.seguro.residencial.application.models.view.coberturas;

import com.seguro.residencial.domain.models.root.itens.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @criado 20/11/2020 - 17:40
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacoteServicosModel {
    private Long id;
    private String descricao;
    private TipoRisco tipoRisco;
    private List<ServicosModel> coberturaServicos;

}
