package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion.ServicioEliminarObservacionTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionTarea {

    private final ServicioEliminarObservacionTarea servicioEliminarObservacionTarea;

    public ServicioAplicacionEliminarObservacionTarea(ServicioEliminarObservacionTarea servicioEliminarObservacionTarea) {
        this.servicioEliminarObservacionTarea = servicioEliminarObservacionTarea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionTarea.ejecutarEliminar(codigo));
    }
}
