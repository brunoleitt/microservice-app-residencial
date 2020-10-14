package com.seguro.residencial.infra.config.security;

import com.seguro.residencial.infra.auth.JwtConfiguration;
import com.seguro.residencial.security.config.SecurityTokenConfig;
import com.seguro.residencial.security.token.converter.TokenConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


/**
 * @criado 18/09/2020 - 01:48
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {

    private final TokenConverter tokenConverter;

    public SecurityCredentialsConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter){
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }


}
