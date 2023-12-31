package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioEliminarPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarPat {

    private final ServicioEliminarPat servicioEliminarPat;

    public ServicioAplicacionEliminarPat(ServicioEliminarPat servicioEliminarPat) {
        this.servicioEliminarPat = servicioEliminarPat;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarPat.ejecutarEliminar(codigo));
    }
}
