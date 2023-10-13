package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioEliminarActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadEstrategica{

    private final ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica;

    public ServicioAplicacionEliminarActividadEstrategica(ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica) {
        this.servicioEliminarActividadEstrategica = servicioEliminarActividadEstrategica;
    }
    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadEstrategica.ejecutarEliminar(codigo));
    }
}
