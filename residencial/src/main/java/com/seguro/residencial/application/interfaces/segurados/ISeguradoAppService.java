package com.seguro.residencial.application.interfaces.segurados;

import com.seguro.residencial.application.models.input.segurados.SeguradoInput;

/**
 * @criado 21/11/2020 - 14:24
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

public interface ISeguradoAppService {
    void registraSegurado(SeguradoInput input, String idCotacao);
}
