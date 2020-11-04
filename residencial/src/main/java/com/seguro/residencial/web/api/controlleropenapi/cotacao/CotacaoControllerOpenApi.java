package com.seguro.residencial.web.api.controlleropenapi.cotacao;

import com.seguro.residencial.application.models.input.cotacao.CriarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Cotacao")
public interface CotacaoControllerOpenApi {

	@ApiOperation("Criar uma nova cotação")
	@ApiParam(name = "corpo", value = "Representação dos dados para criar uma nova cotação", required = true)
    CotacaoCriadaViewModel criarCotacao(CriarCotacaoInput corpo);

}
