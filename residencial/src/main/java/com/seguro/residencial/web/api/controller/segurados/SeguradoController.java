package com.seguro.residencial.web.api.controller.segurados;

import com.seguro.residencial.application.interfaces.segurados.ISeguradoAppService;
import com.seguro.residencial.application.models.input.segurados.SeguradoInput;
import com.seguro.residencial.web.api.controlleropenapi.segurado.SeguradoControllerOpenApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @criado 21/11/2020 - 16:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/cotacao/{idCotacao}/segurado",  produces = MediaType.APPLICATION_JSON_VALUE)
public class SeguradoController implements SeguradoControllerOpenApi {

    private final ISeguradoAppService iSeguradoAppService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void registraSegurado(@PathVariable String idCotacao,  @RequestBody @Valid SeguradoInput input) {
        iSeguradoAppService.registraSegurado(input,idCotacao);
    }
}
