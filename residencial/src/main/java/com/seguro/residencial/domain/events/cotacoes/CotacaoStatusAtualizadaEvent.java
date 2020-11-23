package com.seguro.residencial.domain.events.cotacoes;

import com.seguro.residencial.coreapi.model.baseevent.CotacaoEvent;
import lombok.Getter;

/**
 * @criado 23/11/2020 - 11:08
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class CotacaoStatusAtualizadaEvent {

    public CotacaoStatusAtualizadaEvent(String codigoCotacao,
                                        String statusAnterior, String statusNovo) {
        this.codigoCotacao = codigoCotacao;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
    }

    private String codigoCotacao;
    private String statusAnterior;
    private String statusNovo;
}
