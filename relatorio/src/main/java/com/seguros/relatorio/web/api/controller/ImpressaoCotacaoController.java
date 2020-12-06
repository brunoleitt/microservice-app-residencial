package com.seguros.relatorio.web.api.controller;

import com.seguros.relatorio.application.assembler.relatorios.cotacoes.Cotacao;
import com.seguros.relatorio.application.interfaces.IImpressaoAppService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @criado 02/12/2020 - 11:41
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/cotacao",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ImpressaoCotacaoController {

    private final IImpressaoAppService impressaoAppService;

    @GetMapping("/{codigoCotacao}")
    public ResponseEntity<Cotacao> consultarCotacao(@PathVariable String codigoCotacao) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(impressaoAppService.consultaCotacao(codigoCotacao));
    }

}
