package com.ccoa.planeacionestrategica.infraestructura.seguridad.configuracion;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class ConfiguracionCors {

    @Bean
    @Transactional
    CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration corsConfiguration =  new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:62953"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);

        return source;
    }
}
