package com.seguro.residencial.domain.commands.cotacoes;

import com.seguro.residencial.domain.commands.validacoes.cotacao.AtualizarStatusCommandValidation;
import com.seguro.residencial.domain.models.root.cotacoes.StatusCotacao;
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
                                         StatusCotacao status) {
        this.codigoCotacao = codigoCotacao;
        this.status = status;
    }

    void isValid() {
        new AtualizarStatusCommandValidation(this).IsValid();
    }

    @TargetAggregateIdentifier
    private String codigoCotacao;
    private StatusCotacao status;


}
