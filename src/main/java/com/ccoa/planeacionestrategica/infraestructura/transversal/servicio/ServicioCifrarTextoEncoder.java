package com.ccoa.planeacionestrategica.infraestructura.transversal.servicio;

import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCifrarTexto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ServicioCifrarTextoEncoder implements ServicioCifrarTexto {

    private final PasswordEncoder passwordEncoder;

    public ServicioCifrarTextoEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String ejecutar(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean existe(String password, String passwordEncriptada) {
        return passwordEncoder.matches(password,passwordEncriptada);
    }
}
