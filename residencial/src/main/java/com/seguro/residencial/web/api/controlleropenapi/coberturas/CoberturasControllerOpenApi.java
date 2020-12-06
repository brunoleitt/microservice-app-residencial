package com.seguro.residencial.web.api.controlleropenapi.coberturas;

import com.seguro.residencial.application.models.view.api.PacoteCoberturaModel;
import com.seguro.residencial.application.models.view.api.PacoteServicosModel;
import com.seguro.residencial.web.api.controller.exceptionHandle.Problem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "Cotacao")
public interface CoberturasControllerOpenApi {

    @ApiOperation("Consulta lista de cobertura por tipo de Risco e pacote de coberturas")
    @ApiResponses({
            @ApiResponse(code = 400, message = "ID de tipo de risco ou pacote de cobertura invalido ", response = Problem.class),
            @ApiResponse(code = 404, message = "ID de tipo de risco ou pacote de cobertura não encontrada", response = Problem.class)
    })
    ResponseEntity<PacoteCoberturaModel> consultarPacoteCoberturas(
            @ApiParam(value = "ID com o Tipo de Risco", example = "1", required = true)
                    Long idTipoCobertura,
            @ApiParam(value = "ID para o pacote de cobertura", example = "3", required = true)
                    Long idTipoRisco);


    @ApiOperation("Consulta lista de serviços por tipo de Risco e pacote de coberturas")
    @ApiResponses({
            @ApiResponse(code = 400, message = "ID de tipo de risco ou pacote de cobertura invalido ", response = Problem.class),
            @ApiResponse(code = 404, message = "ID de tipo de risco ou pacote de cobertura não encontrada", response = Problem.class)
    })
    ResponseEntity<PacoteServicosModel> consultarPacoteServicosCobertura(@ApiParam(value = "ID com o Tipo de Risco", example = "1", required = true)
                                                                                Long idTipoCobertura,
                                                                         @ApiParam(value = "ID para o pacote de cobertura", example = "3", required = true)
                                                                                Long idTipoRisco);
}
