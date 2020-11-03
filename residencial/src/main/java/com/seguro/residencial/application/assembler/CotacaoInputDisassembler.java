package com.seguro.residencial.application.assembler;


import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @criado 30/10/2020 - 19:59
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
public class CotacaoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public void copyToDomainObject(CriarCotacaoInput criarCotacaoInput, CotacaoRoot cotacaoRoot) {
        modelMapper.map(criarCotacaoInput, cotacaoRoot);
    }

}
