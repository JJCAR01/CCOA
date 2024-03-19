package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.observacion.ServicioEliminarObservacionProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionProyectoArea {

    private final ServicioEliminarObservacionProyectoArea servicioEliminarObservacionProyectoArea;

    public ServicioAplicacionEliminarObservacionProyectoArea(ServicioEliminarObservacionProyectoArea servicioEliminarObservacionProyectoArea) {
        this.servicioEliminarObservacionProyectoArea = servicioEliminarObservacionProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionProyectoArea.ejecutarEliminar(codigo));
    }
}
