package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion.ServicioEliminarObservacionActividadGestionEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionActividadGestionEstrategica {

    private final ServicioEliminarObservacionActividadGestionEstrategica servicioEliminarObservacionActividadGestionEstrategica;

    public ServicioAplicacionEliminarObservacionActividadGestionEstrategica(ServicioEliminarObservacionActividadGestionEstrategica servicioEliminarObservacionActividadGestionEstrategica) {
        this.servicioEliminarObservacionActividadGestionEstrategica = servicioEliminarObservacionActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionActividadGestionEstrategica.ejecutarEliminar(codigo));
    }
}
