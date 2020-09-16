package com.seguros.residencial.cotacao.endpoint.service;

import com.seguro.residencial.core.model.Cotacao;
import com.seguro.residencial.core.repository.CotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CotacaoServices {

    private final CotacaoRepository cotacaoRepository;

    public Iterable<Cotacao> list(Pageable pageable) {
        log.info("Listando todas as cotaões");
        return cotacaoRepository.findAll(pageable);
    }

}
