package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioEliminarSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarSprint {
    private final ServicioEliminarSprint servicioEliminarSprint;

    public ServicioAplicacionEliminarSprint(ServicioEliminarSprint servicioEliminarSprint) {
        this.servicioEliminarSprint = servicioEliminarSprint;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarSprint.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarSprint.eliminarDocumento(codigo));
    }
}
