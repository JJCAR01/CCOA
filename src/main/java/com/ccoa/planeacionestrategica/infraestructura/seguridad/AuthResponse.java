package com.ccoa.planeacionestrategica.infraestructura.seguridad;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthResponse {
    @NonNull
    private String jwt;
}
