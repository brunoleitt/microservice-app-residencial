package com.seguro.residencial.domain.commands.validacoes.cotacao;

import com.seguro.residencial.domain.commands.cotacoes.AtualizarStatusCotacaoCommand;
import com.seguro.residencial.domain.exception.NegocioException;
import lombok.AllArgsConstructor;

/**
 * @criado 23/11/2020 - 12:25
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@AllArgsConstructor
public class AtualizarStatusCommandValidation {

    public AtualizarStatusCotacaoCommand atualizarStatusCotacaoCommand;

    private void validarStatusNovoAnteriorCotacao(){
        if(false)//TODO atualizarStatusCotacaoCommand.getStatusAnterior().equals("PAGAMENTO_APROVADO"))
            throw new NegocioException("Não é possivel realizar alteração de uma cotação efetivada");
    }

    public final void IsValid() {
        validarStatusNovoAnteriorCotacao();
    }
}
