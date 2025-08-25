package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index", "/css/**", "/js/**").permitAll() // Allow public access to basic, static pages
                .anyRequest().authenticated() // Everything else needs login
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login") // Default login page, or create a custom one
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/") // Redirect to index after logout
                .permitAll()
            );
        return http.build();
    }
}
