package com.nttdata.ofertassecundarias.common.secutity.secapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/**
 * @author dpanquev
 * @version 2021-09-14
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.headers()
                .xssProtection()
                .block(true)
                .and()
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "default-src 'self'"))
                .addHeaderWriter(new StaticHeadersWriter("X-XSS-Protection", "1; mode=block"))
                .contentSecurityPolicy("script-src 'self'")
                ;
        httpSecurity.csrf().csrfTokenRepository(new CookieCsrfTokenRepository())
                .requireCsrfProtectionMatcher(
                        httpServletRequest -> httpServletRequest.getMethod().equals("None")
                );

    }
}
