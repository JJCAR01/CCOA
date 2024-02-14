package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.ServicioEliminarProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProyectoArea {
    private final ServicioEliminarProyectoArea servicioEliminarProyectoArea;

    public ServicioAplicacionEliminarProyectoArea(ServicioEliminarProyectoArea servicioEliminarProyectoArea) {
        this.servicioEliminarProyectoArea = servicioEliminarProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarProyectoArea.ejecutarEliminar(codigo));
    }
}
