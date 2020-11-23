package com.seguro.residencial.web.api.controlleropenapi.segurado;

import com.seguro.residencial.application.models.input.segurados.SeguradoInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cliente")
public interface SeguradoControllerOpenApi {

    @ApiOperation("Realiza cadastro dos dados do segurado")
    @ApiParam(name = "corpo", value = "Representação dos dados para registrar um novo segurado da cotação", required = true)
    void registraSegurado(String idCotacao, SeguradoInput input);

}
