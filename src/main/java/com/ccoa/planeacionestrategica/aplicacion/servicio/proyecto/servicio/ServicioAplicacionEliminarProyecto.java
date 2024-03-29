package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
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
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarProyecto.eliminarDocumento(codigo));
    }
}
