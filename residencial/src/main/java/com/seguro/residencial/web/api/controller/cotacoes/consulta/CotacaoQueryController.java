package com.seguro.residencial.web.api.controller.cotacoes.consulta;

import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.domain.exception.NegocioException;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping("v1/residencial/consulta")
@Slf4j
@Api(value = "Endpoints para consultas de cotações residencial")
public class CotacaoQueryController {

    private final ICotacaoQueryAppService iCotacaoQueryAppService;

    public CotacaoQueryController(ICotacaoQueryAppService iCotacaoQueryAppService) {
        this.iCotacaoQueryAppService = iCotacaoQueryAppService;
    }

    @GetMapping()
    public List<CotacaoRoot> listarCotacoes() {
        List<CotacaoRoot> cotacaoRoots = this.iCotacaoQueryAppService.listarCotacoes();

        if (!cotacaoRoots.isEmpty())
            throw new NegocioException(String.format("Não existe cotações cadastradas",
                    "Dados de cotacao"));

        return cotacaoRoots;
    }
}
