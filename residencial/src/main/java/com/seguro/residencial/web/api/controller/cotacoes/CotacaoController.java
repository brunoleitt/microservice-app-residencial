package com.seguro.residencial.web.api.controller.cotacoes;


import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.web.api.controlleropenapi.CotacaoControllerOpenApi;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping(path = "v1/residencial/cotacao",  produces = MediaType.APPLICATION_JSON_VALUE)
public class CotacaoController implements CotacaoControllerOpenApi {

    private final ICotacaoAppService iCotacaoAppService;

    public CotacaoController(ICotacaoAppService _iCotacaoAppService) {
        this.iCotacaoAppService = _iCotacaoAppService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CotacaoCriadaViewModel criarCotacao(@RequestBody @Valid CriarCotacaoInput criarCotacaoInput){

         return iCotacaoAppService.criacaoCotacao(criarCotacaoInput);
    }
}
