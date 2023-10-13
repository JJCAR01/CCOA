package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioEliminarActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadGestion {

    private final ServicioEliminarActividadGestion servicioEliminarActividadGestion;

    public ServicioAplicacionEliminarActividadGestion(ServicioEliminarActividadGestion servicioEliminarActividadGestion) {
        this.servicioEliminarActividadGestion = servicioEliminarActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadGestion.ejecutarEliminar(codigo));
    }
}
