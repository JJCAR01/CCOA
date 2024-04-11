package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioEliminarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioEliminarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadGestionEstrategica {

    private final ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica;
    private final ServicioEliminarTarea servicioEliminarTarea;

    public ServicioAplicacionEliminarActividadGestionEstrategica(ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica, ServicioEliminarTarea servicioEliminarTarea) {
        this.servicioEliminarActividadGestionEstrategica = servicioEliminarActividadGestionEstrategica;
        this.servicioEliminarTarea = servicioEliminarTarea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        this.servicioEliminarTarea.ejecutarEliminarPorActividadGestionEstrategica(codigo);
        return new DtoRespuesta<>(this.servicioEliminarActividadGestionEstrategica.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadGestionEstrategica.eliminarDocumento(codigo));
    }
}
