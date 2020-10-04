package com.seguro.security.filter;


import com.nimbusds.jwt.SignedJWT;
import com.seguro.core.property.JwtConfiguration;
import com.seguro.security.token.converter.TokenConverter;
import com.seguro.security.util.SecurityContextUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;


/**
 * @criado 19/09/2020 - 21:02
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 * OncePerRequestFilter - Executa apenas uma vez por requesição
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JwtTokenAuthorizationFilter  extends OncePerRequestFilter  {

    protected final JwtConfiguration jwtConfiguration;
    protected final TokenConverter tokenConverter;

    @Override
    @SuppressWarnings("Duplicates")
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader(jwtConfiguration.getHeader().getName());

//        /*Valida apenas os serviços necessarios*/
//        if (header == null || !header.startsWith(jwtConfiguration.getHeader().getPrefix())) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        String token = header.replace(jwtConfiguration.getHeader().getPrefix(), "").trim();
//
//        /*Valida se o token veio assinado ou criptografado*/
//        SecurityContextUtil.setSecurityContext(equalsIgnoreCase("signed", jwtConfiguration.getType()) ? validate(token) : decryptValidating(token));
//
//        chain.doFilter(request, response);
    }

    /**
     * Envia o token assinado e criptografado para todos os microservicos
     * @param encryptedToken
     * @return
     */
    @SneakyThrows
    private SignedJWT decryptValidating(String encryptedToken) {
        String signedToken = tokenConverter.decryptToken(encryptedToken);
        tokenConverter.validateTokenSignature(signedToken);
        return SignedJWT.parse(signedToken);
    }

    @SneakyThrows
    private SignedJWT validate(String signedToken) {
        tokenConverter.validateTokenSignature(signedToken);
        return SignedJWT.parse(signedToken);
    }
}
