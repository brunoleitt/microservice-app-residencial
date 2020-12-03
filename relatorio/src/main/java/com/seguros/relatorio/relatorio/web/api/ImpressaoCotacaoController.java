package com.seguros.relatorio.relatorio.web.api;

import com.seguros.relatorio.relatorio.application.interfaces.IImpressaoAppService;
import com.seguros.relatorio.relatorio.domain.model.cotacoes.Cotacao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void consultarCotacao(@PathVariable String codigoCotacao) {
        var obj = impressaoAppService.consultaCotacao(codigoCotacao);
        log.info(obj.getCodigoCotacao());
    }


    @PutMapping("/status/{idCotacao}")
    public void save(@PathVariable String idCotacao){
        var cotacao = new Cotacao();
        var obj = impressaoAppService.registrarImpressaoCotacao(cotacao);
    }
}
