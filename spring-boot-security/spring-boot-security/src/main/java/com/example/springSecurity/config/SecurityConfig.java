package com.example.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springSecurity.springJwt.CustomJWTAuthenticationFilter;
import com.example.springSecurity.springJwt.JwtAuthenticationEntryPoint;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableMethodSecurity
@Slf4j
public class SecurityConfig {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
	JwtAuthenticationEntryPoint jwtAuthenticatonEntryPoint;
	
	@Bean
	public CustomJWTAuthenticationFilter customJwtAuthenticationFilter() {
		return new CustomJWTAuthenticationFilter();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {                
        http.csrf(csrf -> csrf.disable())  
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticatonEntryPoint))               
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    try {
                        auth
                            .requestMatchers("/authenticate").permitAll()
                            .requestMatchers("/api/test/**").permitAll()
                            .anyRequest().authenticated(); //.and().httpBasic(Customizer.withDefaults());
                    } catch (Exception e) {
                        log.error("security filter chain failed", e);
                    }
                });
        
        http.authenticationProvider(authenticationProvider());
                
        return http.build();
    }
   
    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
      return authConfig.getAuthenticationManager();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
     
        return authProvider;
    }
}