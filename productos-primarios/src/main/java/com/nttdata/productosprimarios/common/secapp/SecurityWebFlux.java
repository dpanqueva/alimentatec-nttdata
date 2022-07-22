package com.nttdata.productosprimarios.common.secapp;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author dpanquev
 * @version 2021-09-14
 */
@EnableWebFluxSecurity
public class SecurityWebFlux {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.headers(headers -> {
                    headers.xssProtection(xssProtectionSpec -> xssProtectionSpec.disable());
                })
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/api/products/**", "/actuator/**", "/swagger-doc/**")
                .permitAll()
                .and()
                .httpBasic();
        return http.build();
    }
}
