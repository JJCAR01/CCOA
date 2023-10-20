package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
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
}
