package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;

import java.util.List;

/**
 * @criado 15/10/2020 - 23:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface ICotacaoQueryAppService {
    List<CotacaoRoot> listarCotacoes();
}
