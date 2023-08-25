package com.ccoa.planeacionestrategica.aplicacion.servicio.area;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarArea {

    private final ServicioEliminarArea servicioEliminarArea;

    public ServicioAplicacionEliminarArea(ServicioEliminarArea servicioEliminarArea) {
        this.servicioEliminarArea = servicioEliminarArea;
    }

    @Secured("ROLE_ADMIN")
    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarArea.ejecutarEliminar(codigo));
    }
}
