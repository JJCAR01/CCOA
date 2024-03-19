package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion.ServicioEliminarObservacionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionActividadEstrategica {

    private final ServicioEliminarObservacionActividadEstrategica servicioEliminarObservacionActividadEstrategica;

    public ServicioAplicacionEliminarObservacionActividadEstrategica(ServicioEliminarObservacionActividadEstrategica servicioEliminarObservacionActividadEstrategica) {
        this.servicioEliminarObservacionActividadEstrategica = servicioEliminarObservacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionActividadEstrategica.ejecutarEliminar(codigo));
    }
}
