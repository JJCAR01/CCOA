package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioEliminarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProyecto {
    private final ServicioEliminarProyecto servicioEliminarProyecto;

    public ServicioAplicacionEliminarProyecto(ServicioEliminarProyecto servicioEliminarProyecto) {
        this.servicioEliminarProyecto = servicioEliminarProyecto;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarProyecto.ejecutarEliminar(codigo));
    }
}
