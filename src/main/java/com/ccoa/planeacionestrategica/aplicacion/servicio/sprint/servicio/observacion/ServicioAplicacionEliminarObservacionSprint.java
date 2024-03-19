package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion.ServicioEliminarObservacionSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionSprint {

    private final ServicioEliminarObservacionSprint servicioEliminarObservacionSprint;

    public ServicioAplicacionEliminarObservacionSprint(ServicioEliminarObservacionSprint servicioEliminarObservacionSprint) {
        this.servicioEliminarObservacionSprint = servicioEliminarObservacionSprint;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionSprint.ejecutarEliminar(codigo));
    }
}
