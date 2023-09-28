package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioGuardarGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarGestion {

    private final ServicioGuardarGestion servicioGuardarGestion;

    public ServicioAplicacionGuardarGestion(ServicioGuardarGestion servicioGuardarGestion) {
        this.servicioGuardarGestion = servicioGuardarGestion;
    }

    public DtoRespuesta<Long> ejecutar(DtoGestion dto){
        Gestion gestion = Gestion.of(dto.getIdGestion(), dto.getNombre(), dto.getIdPat());
        return new DtoRespuesta<>(this.servicioGuardarGestion.ejecutarGuardar(gestion));
    }
}
