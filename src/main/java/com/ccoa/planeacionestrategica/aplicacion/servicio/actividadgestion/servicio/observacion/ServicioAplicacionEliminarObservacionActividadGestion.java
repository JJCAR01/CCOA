package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion.ServicioEliminarObservacionActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionActividadGestion {

    private final ServicioEliminarObservacionActividadGestion servicioEliminarObservacionActividadGestion;

    public ServicioAplicacionEliminarObservacionActividadGestion(ServicioEliminarObservacionActividadGestion servicioEliminarObservacionActividadGestion) {
        this.servicioEliminarObservacionActividadGestion = servicioEliminarObservacionActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionActividadGestion.ejecutarEliminar(codigo));
    }
}
