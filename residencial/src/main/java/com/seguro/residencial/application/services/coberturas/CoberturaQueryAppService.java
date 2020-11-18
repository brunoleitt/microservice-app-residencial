package com.seguro.residencial.application.services.coberturas;

import com.seguro.residencial.application.interfaces.ICoberturaQueryAppService;
import com.seguro.residencial.application.models.view.coberturas.CoberturasTipoRiscoModel;
import com.seguro.residencial.domain.interfaces.repository.coberturas.IPacoteCoberturasRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @criado 16/11/2020 - 21:20
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
@AllArgsConstructor
public class CoberturaQueryAppService implements ICoberturaQueryAppService {

    private final IPacoteCoberturasRespository IPacoteCoberturas;

    @Override
    public CoberturasTipoRiscoModel consultarCoberturasTipoRisco(
            Long idTipoRisco, Long idPacoteCobertura) {



        return null;
    }
}
