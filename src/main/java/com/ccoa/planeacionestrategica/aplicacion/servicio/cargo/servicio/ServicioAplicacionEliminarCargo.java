package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioEliminarCargo;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarCargo {

    private final ServicioEliminarCargo servicioEliminarCargo;

    public ServicioAplicacionEliminarCargo(ServicioEliminarCargo servicioEliminarCargo) {
        this.servicioEliminarCargo = servicioEliminarCargo;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarCargo.ejecutarEliminar(codigo));
    }
}
