package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividad.ServicioEliminarActividad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividad {
    private final ServicioEliminarActividad servicioEliminarActividad;
    public ServicioAplicacionEliminarActividad(ServicioEliminarActividad servicioEliminarActividad) {
        this.servicioEliminarActividad = servicioEliminarActividad;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividad.ejecutarEliminar(codigo));
    }
}
