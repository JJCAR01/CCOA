package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioEliminarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioEliminarActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioEliminarPat;
import com.ccoa.planeacionestrategica.dominio.servicio.proyecto.ServicioEliminarProyecto;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.ServicioEliminarProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPat {

    private final ServicioEliminarPat servicioEliminarPat;
    private final ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica;
    private final ServicioEliminarActividadGestion servicioEliminarActividadGestion;
    private final ServicioEliminarProyectoArea servicioEliminarProyectoArea;

    public ServicioAplicacionEliminarPat(ServicioEliminarPat servicioEliminarPat, ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica, ServicioEliminarActividadGestion servicioEliminarActividadGestion, ServicioEliminarProyectoArea servicioEliminarProyectoArea) {
        this.servicioEliminarPat = servicioEliminarPat;
        this.servicioEliminarActividadEstrategica = servicioEliminarActividadEstrategica;
        this.servicioEliminarActividadGestion = servicioEliminarActividadGestion;
        this.servicioEliminarProyectoArea = servicioEliminarProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        this.servicioEliminarActividadEstrategica.ejecutarEliminarPorPat(codigo);
        this.servicioEliminarActividadGestion.ejecutarEliminarPorPat(codigo);
        this.servicioEliminarProyectoArea.ejecutarEliminarPorPat(codigo);
        return new DtoRespuesta<>(this.servicioEliminarPat.ejecutarEliminar(codigo));
    }
}
