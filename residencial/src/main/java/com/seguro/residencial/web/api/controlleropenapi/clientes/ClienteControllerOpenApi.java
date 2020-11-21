package com.seguro.residencial.web.api.controlleropenapi.clientes;

import com.seguro.residencial.application.models.input.cliente.ClienteInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cliente")
public interface ClienteControllerOpenApi {

    @ApiOperation("Realiza cadastro dos dados do segurado")
    @ApiParam(name = "corpo", value = "Representação dos dados para registrar um novo segurado da cotação", required = true)
    void registraCliente(String idCotacao, ClienteInput input);

}
