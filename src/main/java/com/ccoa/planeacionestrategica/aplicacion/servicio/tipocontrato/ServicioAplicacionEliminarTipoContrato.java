package com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.tipocontrato.ServicioEliminarTipoContrato;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTipoContrato {

    private final ServicioEliminarTipoContrato servicioEliminarTipoContrato;

    public ServicioAplicacionEliminarTipoContrato(ServicioEliminarTipoContrato servicioEliminarTipoContrato) {
        this.servicioEliminarTipoContrato = servicioEliminarTipoContrato;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarTipoContrato.ejecutarEliminar(codigo));
    }
}
