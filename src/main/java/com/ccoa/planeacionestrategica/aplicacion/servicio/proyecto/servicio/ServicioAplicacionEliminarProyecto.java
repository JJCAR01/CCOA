package com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioEliminarProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioEliminarSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProyecto {
    private final ServicioEliminarProyecto servicioEliminarProyecto;
    private final ServicioEliminarSprint servicioEliminarSprint;

    public ServicioAplicacionEliminarProyecto(ServicioEliminarProyecto servicioEliminarProyecto, ServicioEliminarSprint servicioEliminarSprint) {
        this.servicioEliminarProyecto = servicioEliminarProyecto;
        this.servicioEliminarSprint = servicioEliminarSprint;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        this.servicioEliminarSprint.ejecutarEliminarPorProyecto(codigo);
        return new DtoRespuesta<>(this.servicioEliminarProyecto.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarProyecto.eliminarDocumento(codigo));
    }
}
