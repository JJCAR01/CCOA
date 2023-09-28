package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioEliminarGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarGestion {

    private final ServicioEliminarGestion servicioEliminarGestion;

    public ServicioAplicacionEliminarGestion(ServicioEliminarGestion servicioEliminarGestion) {
        this.servicioEliminarGestion = servicioEliminarGestion;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarGestion.ejecutarEliminar(codigo));
    }
}
