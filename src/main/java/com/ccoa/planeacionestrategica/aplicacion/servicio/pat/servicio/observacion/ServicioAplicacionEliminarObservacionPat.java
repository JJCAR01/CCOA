package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion.ServicioEliminarObservacionPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionPat {

    private final ServicioEliminarObservacionPat servicioEliminarObservacionPat;

    public ServicioAplicacionEliminarObservacionPat(ServicioEliminarObservacionPat servicioEliminarObservacionPat) {
        this.servicioEliminarObservacionPat = servicioEliminarObservacionPat;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionPat.ejecutarEliminar(codigo));
    }
}
