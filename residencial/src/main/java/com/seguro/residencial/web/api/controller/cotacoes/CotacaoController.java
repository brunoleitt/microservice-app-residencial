package com.seguro.residencial.web.api.controller.cotacoes;


import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping(path = "v1/residencial/cotacao",  produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Api(value = "Endpoints para gerenciar cotacoes residencial")
public class CotacaoController {

    private final ICotacaoAppService iCotacaoAppService;

    public CotacaoController(ICotacaoAppService _iCotacaoAppService) {
        this.iCotacaoAppService = _iCotacaoAppService;
    }

    @PostMapping
    public CompletableFuture<String> criarCotacao(@RequestBody CriarCotacaoInput criarCotacaoInput){
        return iCotacaoAppService.criacaoCotacao(criarCotacaoInput);
    }

}
