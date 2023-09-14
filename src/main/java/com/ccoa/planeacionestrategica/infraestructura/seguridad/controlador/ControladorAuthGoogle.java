package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/ccoa/auth/google")
public class ControladorAuthGoogle {

    @GetMapping("/user")
    public String getUserInfo(Principal principal) {
        if (principal instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) principal;
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) oAuth2User.getAuthorities();
            String userType = getTipo(authorities); // Implementa tu lógica para determinar el tipo de usuario
            String email = oAuth2User.getAttribute("email"); // Obtén el correo electrónico del usuario
            // Realiza la validación y la lógica de tu aplicación aquí
            return "Usuario autenticado: " + email + ", Tipo: " + userType;
        } else {
            return "Usuario no autenticado";
        }
    }

    private String getTipo(List<GrantedAuthority> authorities) {
        // Implementa tu lógica para determinar el tipo de usuario en función de las autoridades (roles) del usuario.
        // Por ejemplo, verifica si el usuario tiene un rol específico como "ROLE_ADMIN".
        // Devuelve el tipo de usuario adecuado según tu aplicación.
        // Puedes personalizar esta lógica según tus necesidades.
        return "UsuarioNormal";
    }
}
