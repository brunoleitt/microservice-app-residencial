package com.seguro.residencial.web.api.controller;


import com.seguro.residencial.application.viewmodels.CriarCotacaoViewModel;
import com.seguro.residencial.application.interfaces.ICotacaoAppService;
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
@RequestMapping("v1/admin/residencial")
@Slf4j
@Api(value = "Endpoints para gerenciar cotacoes residencial")
public class CotacaoController {

    private final ICotacaoAppService ICotacaoAppService;

    public CotacaoController(ICotacaoAppService ICotacaoAppService) {
        this.ICotacaoAppService = ICotacaoAppService;
    }

    @PostMapping
    public CompletableFuture<String> criarCotacao(@RequestBody CriarCotacaoViewModel criarCotacaoViewModel){
        return ICotacaoAppService.criacaoCotacao(criarCotacaoViewModel);
    }

}
