package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login/oauth2/code/google")
public class ControladorAuthGoogle {

    /*@GetMapping
    public Map<String, Object> usuarioActual(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }*/

}
