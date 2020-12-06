package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.models.view.api.CoberturasTipoRiscoModel;

/**
 * @criado 16/11/2020 - 20:58
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

public interface ICoberturaQueryAppService {
    CoberturasTipoRiscoModel consultarCoberturasTipoRisco(Long idTipoRisco, Long idPacoteCobertura);
}
