package com.seguros.relatorio.relatorio.configuration.security;

import com.seguro.residencial.security.config.SecurityTokenConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @criado 02/12/2020 - 16:36
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
