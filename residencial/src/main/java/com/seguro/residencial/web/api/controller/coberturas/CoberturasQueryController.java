package com.seguro.residencial.web.api.controller.coberturas;

import com.seguro.residencial.application.assembler.ObjectMapperUtils;
import com.seguro.residencial.application.models.view.api.PacoteCoberturaModel;
import com.seguro.residencial.application.models.view.api.PacoteServicosModel;
import com.seguro.residencial.domain.exception.coberturas.PacoteCoberturaTipoRiscoNaoEncontradaException;
import com.seguro.residencial.domain.exception.coberturas.ServicosCoberturaTipoRiscoNaoEncontradaException;
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
    @GetMapping("/tiporisco/{idTipoRisco}/coberturas/{idTipoCobertura}/pacote-cobertura")
    public ResponseEntity<PacoteCoberturaModel> consultarPacoteCoberturas(
            @PathVariable Long idTipoRisco,
            @PathVariable Long idTipoCobertura) {

        var coberturasTipoRisco = iPacoteCoberturas.consultarPacoteCoberturas(idTipoCobertura,idTipoRisco)
                .orElseThrow(()-> new PacoteCoberturaTipoRiscoNaoEncontradaException(idTipoCobertura,idTipoRisco));

        return ResponseEntity.status(HttpStatus.OK)
                .body(ObjectMapperUtils.map(coberturasTipoRisco, PacoteCoberturaModel.class));
    }

    @Override
    @GetMapping("/tiporisco/{idTipoRisco}/coberturas/{idTipoCobertura}/pacote-servicos")
        public ResponseEntity<PacoteServicosModel> consultarPacoteServicosCobertura(@PathVariable Long idTipoRisco,
                                                                                @PathVariable Long idTipoCobertura) {

        var pacoteServicos = iPacoteCoberturas.consultarPacoteServicosCobertura(idTipoCobertura,idTipoRisco)
                .orElseThrow(()-> new ServicosCoberturaTipoRiscoNaoEncontradaException(idTipoCobertura,idTipoRisco));

        return ResponseEntity.status(HttpStatus.OK)
                .body(ObjectMapperUtils.map(pacoteServicos, PacoteServicosModel.class));
    }
}
