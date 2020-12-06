package com.seguro.residencial.web.api.controlleropenapi.cotacoes;

import com.seguro.residencial.application.models.view.api.CotacaoModel;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import com.seguro.residencial.web.api.controller.exceptionHandle.Problem;
import io.swagger.annotations.*;

import java.util.List;

@Api(tags = "CotacaoQuery")
public interface CotacaoQueryControllerOpenApi {

	@ApiOperation("Consultar todas as cotações")
	@ApiParam(value = "Realiza a consulta de todas as cotações", required = true)
	List<CotacaoRoot> listarCotacoes();


	@ApiOperation("Buscar uma cotação por id")
	@ApiResponses({@ApiResponse(code = 400, message = "ID da cotação invalido", response = Problem.class)})
	CotacaoModel consultarCotacao(@ApiParam(value = "Id da cotação", required = true) String idCotacao);

}
