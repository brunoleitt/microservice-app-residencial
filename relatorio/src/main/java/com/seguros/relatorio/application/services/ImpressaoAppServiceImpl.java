package com.seguros.relatorio.application.services;

import com.seguros.relatorio.application.assembler.relatorios.cotacoes.Cotacao;
import com.seguros.relatorio.application.interfaces.IImpressaoAppService;
import com.seguros.relatorio.domain.exception.CotacaoNaoEntradaException;
import com.seguros.relatorio.domain.repository.ICotacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @criado 02/12/2020 - 10:46
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@AllArgsConstructor
@Slf4j
@Service
public class ImpressaoAppServiceImpl implements IImpressaoAppService {

    private final ICotacaoRepository cotacaoRepository;

    @Override
    public Cotacao consultaCotacao(String codigoCotacao) {
         return cotacaoRepository.findById(codigoCotacao)
                 .orElseThrow(() -> new CotacaoNaoEntradaException(codigoCotacao));
    }

    @Override
    public Cotacao registrarImpressaoCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }
}
