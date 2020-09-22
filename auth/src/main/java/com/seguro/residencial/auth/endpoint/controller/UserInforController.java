package com.seguro.residencial.auth.endpoint.controller;

import com.seguro.residencial.core.model.ApplicationUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @criado 20/09/2020 - 02:52
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@RestController
@RequestMapping("user")
@Api(value = "Endpoints para gerenciar as informações do usuário")
public class UserInforController {

    @GetMapping(path = "informação", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Irá recuperar as informações do usuário disponíveis no token", response = ApplicationUser.class)
    public ResponseEntity<ApplicationUser> getUserInfo(Principal principal) {
        ApplicationUser applicationUser = (ApplicationUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(applicationUser, HttpStatus.OK);
    }

}
