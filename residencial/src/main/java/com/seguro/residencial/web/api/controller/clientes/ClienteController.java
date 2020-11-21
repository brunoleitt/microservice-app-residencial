package com.seguro.residencial.web.api.controller.clientes;

import com.seguro.residencial.application.interfaces.clientes.IClienteAppService;
import com.seguro.residencial.application.models.input.cliente.ClienteInput;
import com.seguro.residencial.web.api.controlleropenapi.clientes.ClienteControllerOpenApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @criado 21/11/2020 - 16:37
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/cotacao/{idCotacao}/cliente",  produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController implements ClienteControllerOpenApi {

    private final IClienteAppService iClienteAppService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void registraCliente(@PathVariable String idCotacao,  @RequestBody @Valid  ClienteInput input) {
        iClienteAppService.registrarCliente(input,idCotacao);
    }
}
