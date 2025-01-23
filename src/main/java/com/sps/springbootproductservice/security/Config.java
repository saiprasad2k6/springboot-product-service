//package com.sps.springbootproductservice.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class Config {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
//                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
//        return http.build();
//    }
//}
