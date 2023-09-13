package com.ccoa.planeacionestrategica.infraestructura.seguridad.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

public class ConfiguracionGoogle {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }
    private ClientRegistration googleClientRegistration() {
        return ClientRegistration
                .withRegistrationId("google")
                .clientId("TU_ID_DE_CLIENTE_DE_GOOGLE")
                .clientSecret("TU_SECRET_DE_CLIENTE_DE_GOOGLE")
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v3/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName("id")
                .clientName("Google")
                .build();
    }
    

}
