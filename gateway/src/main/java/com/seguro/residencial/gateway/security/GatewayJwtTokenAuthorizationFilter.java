package com.seguro.residencial.gateway.security;

import com.netflix.zuul.context.RequestContext;
import com.nimbusds.jwt.SignedJWT;
import com.seguro.residencial.core.property.JwtConfiguration;
import com.seguro.residencial.security.filter.JwtTokenAuthorizationFilter;
import com.seguro.residencial.security.token.converter.TokenConverter;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.seguro.residencial.security.util.SecurityContextUtil.setSecurityContext;

/**
 * @criado 20/09/2020 - 18:10
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class GatewayJwtTokenAuthorizationFilter extends JwtTokenAuthorizationFilter {

    public GatewayJwtTokenAuthorizationFilter(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration, tokenConverter);
    }

    /**
     * Requesição sempre realizada pelo FrontEnd
     *
     */
    @Override
    @SneakyThrows
    @SuppressWarnings("duplicates")
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader(jwtConfiguration.getHeader().getName());

        if (header == null || !header.startsWith(jwtConfiguration.getHeader().getPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(jwtConfiguration.getHeader().getPrefix(), "").trim();

        //Recebe o Token criptografo
        String signedToken = tokenConverter.decryptToken(token);

        tokenConverter.validateTokenSignature(signedToken);

        setSecurityContext(SignedJWT.parse(signedToken));

        if (jwtConfiguration.getType().equalsIgnoreCase("signed"))
            RequestContext.getCurrentContext().addZuulRequestHeader("Authorization", jwtConfiguration.getHeader().getPrefix() + signedToken);

        chain.doFilter(request, response);
    }
}
