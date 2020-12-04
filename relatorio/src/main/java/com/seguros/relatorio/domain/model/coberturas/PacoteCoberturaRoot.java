package com.seguros.relatorio.domain.model.coberturas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * @criado 02/12/2020 - 10:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacoteCoberturaRoot {
    private String descricaoPacoteCobertura;
    private String premioBaseCotacao;
    private String premioLiquidoCotacao;
    private List<Coberturas> coberturas;
    private List<CoberturasServicos> coberturasServicos;
}
