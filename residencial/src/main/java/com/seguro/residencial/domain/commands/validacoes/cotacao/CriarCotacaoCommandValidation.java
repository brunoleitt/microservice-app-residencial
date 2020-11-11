package com.seguro.residencial.domain.commands.validacoes.cotacao;

import com.seguro.residencial.domain.commands.cotacoes.RegistrarCotacaoCommand;
import com.seguro.residencial.domain.exception.NegocioException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @criado 31/10/2020 - 18:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Getter
@Setter
public class CriarCotacaoCommandValidation  {

    public RegistrarCotacaoCommand criarCotacaoCommand;

    public CriarCotacaoCommandValidation(RegistrarCotacaoCommand cotacaoCommand) {
        this.criarCotacaoCommand = cotacaoCommand;
    }

    public final void IsValid() {
        validaDataInicioVigencia();
    }

    private void validaDataInicioVigencia(){
        int qtdDiasDiferencaDataAtual = 0;
        if (this.criarCotacaoCommand.getDataVigenciaInicial().compareTo(LocalDate.now()) < qtdDiasDiferencaDataAtual)
            throw new NegocioException("Data de inicio vigencia da cotação não pode ser inferior a data atual");
    }
}
