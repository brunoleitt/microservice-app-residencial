package com.seguro.residencial.domain.commands.cotacoes;

/**
 * @criado 12/10/2020 - 14:19
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * Realizar persistencia para consultar dados de cotacao em base de cash
 */
public class RegistrarCotacaoQueryCommand  {

    public RegistrarCotacaoQueryCommand(Long id, String codigoCotacao) {
        this.id = id;
        this.codigoCotacao = codigoCotacao;
    }

    private Long id;
    private String codigoCotacao;
}
