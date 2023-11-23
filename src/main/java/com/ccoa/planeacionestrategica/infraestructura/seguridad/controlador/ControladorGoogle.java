package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLoginGoogle;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.utilidad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ccoa/auth")
public class ControladorGoogle {

    private final JwtUtil jwtUtil;
    @Autowired
    public ControladorGoogle(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/google")
    public ResponseEntity<AuthResponse> loginWithGoogle(@RequestBody DtoLoginGoogle dtoGoogleLogin) {
        // Asumiendo que DtoGoogleLogin contiene los atributos relevantes de Google, como el token o el ID del usuario
        // Aquí debes manejar la lógica de autenticación con Google y generar el token JWT
        String googleIdToken = dtoGoogleLogin.getGoogleEmail();
        // ... Lógica para validar y autenticar al usuario con Google

        // Generar el token JWT
        String jwt = this.jwtUtil.create(googleIdToken, "GOOGLE_USER_TYPE");

        // Devolver la respuesta con el token JWT
        return ResponseEntity.ok(new AuthResponse(jwt));
    }


}
