package com.ccoa.planeacionestrategica.infraestructura.configuracion;

import com.ccoa.planeacionestrategica.infraestructura.filtro.FiltroAutenticacion;
import com.ccoa.planeacionestrategica.infraestructura.servicio.ServicioValidacionToken;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigurationSecurity {
        private static final String URL_PATTERN = "/*";

        @Bean
        public FilterRegistrationBean<FiltroAutenticacion> authenticationFilter(ServicioValidacionToken tokenValidationService){
            FilterRegistrationBean<FiltroAutenticacion> registrationBean = new FilterRegistrationBean<>();

            registrationBean.setFilter(new FiltroAutenticacion(tokenValidationService, new String[]{"/ccoa/login","/ccoa/usuarios","/ccoa/areas"
                    ,"/ccoa/cargos","/ccoa/pats"}));
            registrationBean.addUrlPatterns(URL_PATTERN);

            return registrationBean;
        }
}
