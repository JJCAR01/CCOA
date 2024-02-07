package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioEliminarActividadGestionEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadGestionEstrategica {

    private final ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica;

    public ServicioAplicacionEliminarActividadGestionEstrategica(ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica) {
        this.servicioEliminarActividadGestionEstrategica = servicioEliminarActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadGestionEstrategica.ejecutarEliminar(codigo));
    }
}