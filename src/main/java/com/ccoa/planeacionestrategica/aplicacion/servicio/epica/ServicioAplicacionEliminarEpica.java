package com.ccoa.planeacionestrategica.aplicacion.servicio.epica;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.epica.ServicioEliminarEpica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarEpica {

    private final ServicioEliminarEpica servicioEliminarEpica;

    public ServicioAplicacionEliminarEpica(ServicioEliminarEpica servicioEliminarEpica) {
        this.servicioEliminarEpica = servicioEliminarEpica;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarEpica.ejecutarEliminar(codigo));
    }
}
