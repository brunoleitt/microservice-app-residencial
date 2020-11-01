package com.seguro.residencial.application.assembler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;

/**
 * @criado 30/10/2020 - 19:59
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
public class CotacaoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public CotacaoRoot toDomainObject(CriarCotacaoInput criarCotacaoInput) {
        return modelMapper.map(criarCotacaoInput, CotacaoRoot.class);
    }

    public void copyToDomainObject(CriarCotacaoInput criarCotacaoInput, CotacaoRoot cotacaoRoot) {
        modelMapper.map(criarCotacaoInput, cotacaoRoot);
    }

}
