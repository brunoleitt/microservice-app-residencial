package com.seguro.residencial.web.api.controller;


import com.seguro.residencial.application.viewmodels.CriarCotacaoViewModel;
import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.domain.interfaces.repository.cotacao.ICotacaoQueryRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping("v1/residencial/cotacao")
@Slf4j
@Api(value = "Endpoints para gerenciar cotacoes residencial")
public class CotacaoController {

    private final ICotacaoAppService iCotacaoAppService;

    public CotacaoController(ICotacaoAppService _iCotacaoAppService) {
        this.iCotacaoAppService = _iCotacaoAppService;
    }

    @PostMapping
    public CompletableFuture<String> criarCotacao(@RequestBody CriarCotacaoViewModel criarCotacaoViewModel){
        return iCotacaoAppService.criacaoCotacao(criarCotacaoViewModel);
    }

}
