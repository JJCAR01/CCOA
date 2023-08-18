package com.ccoa.planeacionestrategica.infraestructura.adaptador.servicio;

import com.ccoa.planeacionestrategica.aplicacion.encriptar.ServicioAplicacionEncriptarPassword;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class ServicioEncriptarPassword implements ServicioAplicacionEncriptarPassword {

    @Override
    public String ejecutar(String text) {
        return DigestUtils.sha256Hex(text);
    }
}
