package com.seguro.residencial.gateway.filter;


import com.seguro.residencial.infra.auth.JwtConfiguration;
import com.seguro.residencial.security.config.SecurityTokenConfig;
import com.seguro.residencial.security.token.converter.TokenConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @criado 20/09/2020 - 18:20
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@EnableWebSecurity
public class SecurityConfig  extends SecurityTokenConfig {
    private final TokenConverter tokenConverter;

    public SecurityConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.addFilterAfter(new GatewayJwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
}
