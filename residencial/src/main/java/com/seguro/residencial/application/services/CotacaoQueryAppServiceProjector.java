package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.domain.exception.EntidadeNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @criado 15/10/2020 - 23:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoQueryAppServiceProjector implements ICotacaoQueryAppService {

    private final ICotacaoQueryRepository iCotacaoQueryRepository;

    public CotacaoQueryAppServiceProjector(ICotacaoQueryRepository iCotacaoQueryRepository) {
        this.iCotacaoQueryRepository = iCotacaoQueryRepository;
    }

    @Override
    public List<CotacaoRoot> listarCotacoes() {
        var cotacao = iCotacaoQueryRepository.findAll();

        if (cotacao.isEmpty())
            throw new EntidadeNaoEncontradaException("Entidade não foi encontrada");

        return cotacao;
    }

}
