package com.ccoa.planeacionestrategica.infraestructura.seguridad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLoginGoogle;
import com.ccoa.planeacionestrategica.infraestructura.seguridad.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ccoa/auth")
public class ControladorGoogle {


    @PostMapping("/google")
    public ResponseEntity<AuthResponse> loginWithGoogle(@RequestBody DtoLoginGoogle dtoGoogleLogin) {
        return ResponseEntity.ok(new AuthResponse(dtoGoogleLogin.getGoogleToken()));
    }


}
