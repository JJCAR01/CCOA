package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioEliminarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTarea {
    private final ServicioEliminarTarea servicioEliminarTarea;

    public ServicioAplicacionEliminarTarea(ServicioEliminarTarea servicioEliminarTarea) {
        this.servicioEliminarTarea = servicioEliminarTarea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTarea.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTarea.eliminarDocumento(codigo));
    }
}
