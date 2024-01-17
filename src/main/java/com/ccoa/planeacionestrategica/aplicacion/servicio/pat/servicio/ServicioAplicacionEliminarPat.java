package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioEliminarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioEliminarActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioEliminarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPat {

    private final ServicioEliminarPat servicioEliminarPat;
    private final ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica;
    private final ServicioEliminarActividadGestion servicioEliminarActividadGestion;

    public ServicioAplicacionEliminarPat(ServicioEliminarPat servicioEliminarPat, ServicioEliminarActividadEstrategica servicioEliminarActividadEstrategica, ServicioEliminarActividadGestion servicioEliminarActividadGestion) {
        this.servicioEliminarPat = servicioEliminarPat;
        this.servicioEliminarActividadEstrategica = servicioEliminarActividadEstrategica;
        this.servicioEliminarActividadGestion = servicioEliminarActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        this.servicioEliminarActividadEstrategica.ejecutarEliminarPorPat(codigo);
        this.servicioEliminarActividadGestion.ejecutarEliminarPorPat(codigo);
        return new DtoRespuesta<>(this.servicioEliminarPat.ejecutarEliminar(codigo));
    }
}
