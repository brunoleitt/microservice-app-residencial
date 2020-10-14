package com.seguro.residencial.domain.events;

import com.seguro.residencial.coreapi.model.baseevent.BaseEvent;

/**
 * @criado 12/10/2020 - 14:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class CriacaoCotacaoEvent extends BaseEvent<String> {

    public final String titulo;

    public CriacaoCotacaoEvent(String id, String titulo) {
        super(id);
        this.titulo = titulo;
    }
}
