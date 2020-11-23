package com.seguro.residencial.web.api.controlleropenapi.cotacoes;

import com.seguro.residencial.application.models.input.cotacao.AtualizarStatusInput;
import com.seguro.residencial.application.models.input.cotacao.RegistrarCotacaoInput;
import com.seguro.residencial.application.models.view.CotacaoRegistradaViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = "Cotacao")
public interface CotacaoControllerOpenApi {

	@ApiOperation("Criar uma nova cotação")
	@ApiParam(name = "corpo", value = "Representação dos dados para criar uma nova cotação", required = true)
	CotacaoRegistradaViewModel criarCotacao(RegistrarCotacaoInput corpo);

	@ApiOperation("Atualiza o status da cotação")
	@ApiParam(name = "corpo", value = "Representação dos dados para atualizar o status da cotação", required = true)
	void atualizarStatusCotacao(String idCotacao, AtualizarStatusInput atualizarStatusInput);

}
