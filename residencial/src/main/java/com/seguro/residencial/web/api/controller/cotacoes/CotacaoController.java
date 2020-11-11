package com.seguro.residencial.web.api.controller.cotacoes;


import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.input.cotacao.RegistrarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoRegistradaViewModel;
import com.seguro.residencial.web.api.controlleropenapi.cotacao.CotacaoControllerOpenApi;
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
    public CotacaoRegistradaViewModel criarCotacao(@RequestBody @Valid RegistrarCotacaoInput criarCotacaoInput){
         return iCotacaoAppService.criacaoCotacao(criarCotacaoInput);
    }
}
