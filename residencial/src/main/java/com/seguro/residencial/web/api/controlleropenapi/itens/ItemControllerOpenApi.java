package com.seguro.residencial.web.api.controlleropenapi.itens;

import com.seguro.residencial.application.models.input.item.RegistrarItemInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Item")
public interface ItemControllerOpenApi {

    @ApiOperation("Criar um novo item")
    @ApiParam(name = "corpo", value = "Representação dos dados para criar um novo item da cotação", required = true)
    void registrarItem(String idCotacao, RegistrarItemInput input);

}
