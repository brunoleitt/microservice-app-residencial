package com.seguro.residencial.application.assembler.kafka;

/**
 * @criado 24/11/2020 - 22:06
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpressaoCotacaoResource {

    private String codigoCotacao;
    private String tipoCalculo;

    public ImpressaoCotacaoResource(final CotacaoRoot cotacaoRoot) {
        this.codigoCotacao = cotacaoRoot.getCodigoCotacao();
        this.tipoCalculo = cotacaoRoot.getTipoCalculo().getDescricao();
    }
}
