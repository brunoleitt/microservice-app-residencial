package com.seguro.residencial.application.interfaces;

import com.seguro.residencial.application.models.input.item.RegistrarItemInput;

/**
 * @criado 07/11/2020 - 17:41
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public interface IItemAppService  {
    void registrarItem(String idCotacao, RegistrarItemInput item);
}
