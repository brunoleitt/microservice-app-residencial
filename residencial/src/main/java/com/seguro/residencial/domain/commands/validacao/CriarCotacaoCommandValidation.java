package com.seguro.residencial.domain.commands.validacao;

import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.exception.NegocioException;
import lombok.Getter;
import lombok.Setter;

/**
 * @criado 31/10/2020 - 18:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CriarCotacaoCommandValidation  {

    public CriarCotacaoCommand cotacaoCommand;

    public CriarCotacaoCommandValidation(CriarCotacaoCommand cotacaoCommand) {
        this.cotacaoCommand = cotacaoCommand;
    }

    public final void IsValid() {

        //TODO Validar vigencia Inicial da cotação

        validaDataInicioVigencia();
    }

    private void validaDataInicioVigencia(){
        if (false)
            throw new NegocioException("Data de inicio vigencia da cotação não pode ser inferior a data atual");
    }
}
