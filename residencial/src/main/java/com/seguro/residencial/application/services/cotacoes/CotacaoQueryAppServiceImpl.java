package com.seguro.residencial.application.services.cotacoes;

import com.seguro.residencial.application.assembler.CotacaoModelAssembler;
import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.application.models.view.api.CotacaoModel;
import com.seguro.residencial.domain.exception.CotacaoNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @criado 15/10/2020 - 23:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoQueryAppServiceImpl implements ICotacaoQueryAppService {

    private final ICotacaoQueryRepository iCotacaoQueryRepository;

    @Autowired
    private CotacaoModelAssembler cotacaoModelAssembler;

    public CotacaoQueryAppServiceImpl(ICotacaoQueryRepository iCotacaoQueryRepository) {
        this.iCotacaoQueryRepository = iCotacaoQueryRepository;
    }

    @Override
    public List<CotacaoRoot> listarCotacoes() {
        return iCotacaoQueryRepository.buscarTodos();
    }

    @Override
    public CotacaoModel consultarCotacao(String codigoCotacao) {
         var cotacao = iCotacaoQueryRepository.consultarCotacao(codigoCotacao)
                .orElseThrow(() -> new CotacaoNaoEncontradaException(codigoCotacao));

         return cotacaoModelAssembler.toModel(cotacao);
    }

}
