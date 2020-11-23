package com.seguro.residencial.domain.commands.cotacoes;

import com.seguro.residencial.domain.commands.validacoes.cotacao.AtualizarStatusCommandValidation;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @criado 23/11/2020 - 11:06
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
public class AtualizarStatusCotacaoCommand  {

    public AtualizarStatusCotacaoCommand(String codigoCotacao,
                                         String statusAnterior, String statusNovo) {
        this.codigoCotacao = codigoCotacao;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
    }

    void isValid() {
        new AtualizarStatusCommandValidation(this).IsValid();
    }

    @TargetAggregateIdentifier
    private String codigoCotacao;
    private String statusAnterior;
    private String statusNovo;

}
