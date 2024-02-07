package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioEliminarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioEliminarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioEliminarProyecto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadEstrategica{

    private final ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica;
    private final ServicioEliminarProyecto servicioEliminarProyecto;
    private final ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica;

    public ServicioAplicacionEliminarActividadEstrategica(ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica, ServicioEliminarProyecto servicioEliminarProyecto, ServicioEliminarActividadGestionEstrategica servicioEliminarActividadGestionEstrategica) {
        this.servicioEliminarActividadEstrategica = servicioEliminarActividadEstrategica;
        this.servicioEliminarProyecto = servicioEliminarProyecto;
        this.servicioEliminarActividadGestionEstrategica = servicioEliminarActividadGestionEstrategica;
    }
    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        servicioEliminarProyecto.ejecutarEliminarPorActividadEstrategica(codigo);
        servicioEliminarActividadGestionEstrategica.ejecutarEliminarPorActEstrategica(codigo);
        return new DtoRespuesta<>(this.servicioEliminarActividadEstrategica.ejecutarEliminar(codigo));
    }
}
