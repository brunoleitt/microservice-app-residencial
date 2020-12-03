package com.seguro.residencial.security.config;

import com.seguro.residencial.infra.auth.JwtConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@AllArgsConstructor
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

    //private final JwtConfiguration jwtConfiguration;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
//                .and()
//                .sessionManagement().sessionCreationPolicy(STATELESS);
//                .and()
//                .exceptionHandling().authenticationEntryPoint((req, resp, e) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .authorizeRequests()
//                .antMatchers(jwtConfiguration.getLoginUrl(),"/**/swagger-ui.html").permitAll()
//                .antMatchers(HttpMethod.GET, "/**/swagger-resources/**", "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**").permitAll()
//                .antMatchers("/residencial/v1/admin/**").hasRole("ADMIN")
//                .antMatchers("/auth/user/**").hasAnyRole("ADMIN", "USER");
                //.anyRequest().authenticated();
    }
}