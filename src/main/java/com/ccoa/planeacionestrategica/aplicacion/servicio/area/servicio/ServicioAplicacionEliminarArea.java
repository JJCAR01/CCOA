package com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioEliminarArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarArea {

    private final ServicioEliminarArea servicioEliminarArea;

    public ServicioAplicacionEliminarArea(ServicioEliminarArea servicioEliminarArea) {
        this.servicioEliminarArea = servicioEliminarArea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarArea.ejecutarEliminar(codigo));
    }
}
