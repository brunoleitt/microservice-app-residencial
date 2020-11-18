package com.seguro.residencial.web.api.controller.coberturas;

import com.seguro.residencial.application.assembler.ObjectMapperUtils;
import com.seguro.residencial.application.models.view.coberturas.PacoteCoberturaDTO;
import com.seguro.residencial.domain.exception.coberturas.PacoteCoberturaTipoRiscoNaoEncontradaException;
import com.seguro.residencial.domain.interfaces.repository.coberturas.IPacoteCoberturasRespository;
import com.seguro.residencial.web.api.controlleropenapi.coberturas.CoberturasControllerOpenApi;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping(path = "v1/coberturas/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Api(value = "Endpoints para consultas de coberturas e servicos Residencial")
public class CoberturasQueryController implements CoberturasControllerOpenApi {

    private final IPacoteCoberturasRespository iPacoteCoberturas;

    @Override()
    @GetMapping("/tiporisco/{idTipoRisco}/coberturas/{idTipoCobertura}")
    public ResponseEntity<PacoteCoberturaDTO> consultarCoberturasTipoRisco(
            @PathVariable Long idTipoRisco,
            @PathVariable Long idTipoCobertura) {

        var coberturasTipoRisco = iPacoteCoberturas.findCoberturaById(idTipoCobertura,idTipoRisco)
                .orElseThrow(()-> new PacoteCoberturaTipoRiscoNaoEncontradaException(idTipoCobertura,idTipoRisco));

        return ResponseEntity.status(HttpStatus.OK)
                .body(ObjectMapperUtils.map(coberturasTipoRisco,PacoteCoberturaDTO.class));
    }
}
