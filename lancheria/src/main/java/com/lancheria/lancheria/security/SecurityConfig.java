// package com.lancheria.lancheria.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity()
// public class SecurityConfig {
// @Bean
// SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// return http
// .authorizeHttpRequests(
// authorizeConfig -> {
// authorizeConfig.requestMatchers("/usuario/buscaUsuario").permitAll();
// authorizeConfig.requestMatchers("/usuario/listarUsuarios").permitAll();
// authorizeConfig.requestMatchers("/usuario/login").permitAll();
// authorizeConfig.requestMatchers("/logout").permitAll();
// authorizeConfig.anyRequest().authenticated();
// })
// // .formLogin(Customizer.withDefaults())
// .oauth2Login(Customizer.withDefaults())
// .build();
// }
// }
