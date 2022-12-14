package com.equipo5.reto3.service.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
                .antMatchers("/", "/error", "/webjars/**,",
                        "/api/**", "index.html", "/webjars/**","/js/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login(); //.defaultSuccessUrl("http://localhost:8080/homepage.htm", true); esto funciona para redireccionar

        http.cors().and().csrf().disable();

    }
}
