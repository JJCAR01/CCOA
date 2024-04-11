package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioEliminarActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioEliminarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadGestion {

    private final ServicioEliminarActividadGestion servicioEliminarActividadGestion;
    private final ServicioEliminarTarea servicioEliminarTarea;

    public ServicioAplicacionEliminarActividadGestion(ServicioEliminarActividadGestion servicioEliminarActividadGestion, ServicioEliminarTarea servicioEliminarTarea) {
        this.servicioEliminarActividadGestion = servicioEliminarActividadGestion;
        this.servicioEliminarTarea = servicioEliminarTarea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        this.servicioEliminarTarea.ejecutarEliminarPorActividadGestion(codigo);
        return new DtoRespuesta<>(this.servicioEliminarActividadGestion.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadGestion.eliminarDocumento(codigo));
    }
}
