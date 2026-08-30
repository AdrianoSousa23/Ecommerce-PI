package com.ecommerce.ecommerceInimigosCodigo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/cadastrar-usuarios", "/salvar", "/css/**", "/img/**", "/*.css", "/*.gif").permitAll()
                        .requestMatchers("/lista-usuarios", "/buscar-usuarios").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/lista-produtos", "/cadastrar-produtos", "/salvar-produto", "/editar-produto/**", "/deletar-produto/**")
                        .hasAnyAuthority("ROLE_ESTOQUISTA", "ROLE_ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/processar-login")
                        .usernameParameter("usuario")
                        .passwordParameter("senha")
                        .defaultSuccessUrl("/principal", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(Customizer.withDefaults())
                .build();
    }
}