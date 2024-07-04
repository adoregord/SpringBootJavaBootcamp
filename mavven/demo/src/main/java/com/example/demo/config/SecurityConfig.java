package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(PasswordEncoder().encode)
    }
    
}