package com.seguro.residencial.security.filter;

import com.nimbusds.jwt.SignedJWT;
import com.seguro.residencial.core.property.JwtConfiguration;
import com.seguro.residencial.security.util.SecurityContextUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @criado 19/09/2020 - 21:02
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

public class JwtTokenAuthorizationFilter  {

}
