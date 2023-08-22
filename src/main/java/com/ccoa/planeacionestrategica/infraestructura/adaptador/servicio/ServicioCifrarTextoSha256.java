package com.ccoa.planeacionestrategica.infraestructura.adaptador.servicio;

import com.ccoa.planeacionestrategica.dominio.servicio.ServicioCifrarTexto;
import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

@Component
public class ServicioCifrarTextoSha256 implements ServicioCifrarTexto {
    @Override
    public String ejecutar(String texto) {
        return DigestUtils.sha256Hex(texto);
    }
}
