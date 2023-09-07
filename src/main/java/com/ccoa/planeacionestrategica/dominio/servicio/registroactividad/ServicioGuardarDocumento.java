package com.ccoa.planeacionestrategica.dominio.servicio.registroactividad;

import com.ccoa.planeacionestrategica.dominio.modelo.registroactividad.Documento;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRegistroActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarDocumento {

    private final RepositorioRegistroActividad repositorioRegistroActividad;

    public ServicioGuardarDocumento(RepositorioRegistroActividad repositorioRegistroActividad) {
        this.repositorioRegistroActividad = repositorioRegistroActividad;
    }

    public Long ejecutar(Documento documento, Long idRegistroActividad) {

        return this.repositorioRegistroActividad.guardarDocumento(documento, idRegistroActividad);
    }
}
