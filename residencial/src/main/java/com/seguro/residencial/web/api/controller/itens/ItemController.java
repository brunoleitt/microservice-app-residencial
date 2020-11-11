package com.seguro.residencial.web.api.controller.itens;

import com.seguro.residencial.application.interfaces.IItemAppService;
import com.seguro.residencial.application.models.input.item.RegistrarItemInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @criado 07/11/2020 - 18:05
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/residencial/item",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    private final IItemAppService itemAppService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCotacao(@RequestBody RegistrarItemInput input){
         itemAppService.registrarItem(input);
    }

}
