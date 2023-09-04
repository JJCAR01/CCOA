package com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.tipogi.ServicioEliminarTipoGI;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTipoGI {

    private final ServicioEliminarTipoGI servicioEliminarTipoGI;

    public ServicioAplicacionEliminarTipoGI(ServicioEliminarTipoGI servicioEliminarTipoGI) {
        this.servicioEliminarTipoGI = servicioEliminarTipoGI;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTipoGI.ejecutarEliminar(codigo));
    }
}
