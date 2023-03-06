//package com.learningSpring.MovieApp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//public class SecurityConfig {
//    //https://stackoverflow.com/questions/74853613/basic-authentication-on-rest-service-with-spring-boot
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // Enable and configure CORS
//        http.cors().configurationSource(corsConfigurationSource());
//
//        return http.build();
//    }
//
//    private CorsConfigurationSource corsConfigurationSource() {
//        // Very permissive CORS config...
//        final var configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setExposedHeaders(Arrays.asList("*"));
//
//        // Limited to API routes (neither actuator nor Swagger-UI)
//        final var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/greet/**", configuration);
//
//        return source;
//    }
//}