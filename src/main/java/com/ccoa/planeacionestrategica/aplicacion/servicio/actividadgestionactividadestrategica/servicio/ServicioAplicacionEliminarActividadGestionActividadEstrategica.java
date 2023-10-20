package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.ServicioEliminarActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadGestionActividadEstrategica {

    private final ServicioEliminarActividadGestionActividadEstrategica servicioEliminarActividadGestionActividadEstrategica;

    public ServicioAplicacionEliminarActividadGestionActividadEstrategica(ServicioEliminarActividadGestionActividadEstrategica servicioEliminarActividadGestionActividadEstrategica) {
        this.servicioEliminarActividadGestionActividadEstrategica = servicioEliminarActividadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadGestionActividadEstrategica.ejecutarEliminar(codigo));
    }
}
