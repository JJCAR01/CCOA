package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion.ServicioEliminarObservacionSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarObservacionSprintProyectoArea {

    private final ServicioEliminarObservacionSprintProyectoArea servicioEliminarObservacionSprintProyectoArea;

    public ServicioAplicacionEliminarObservacionSprintProyectoArea(ServicioEliminarObservacionSprintProyectoArea servicioEliminarObservacionSprintProyectoArea) {
        this.servicioEliminarObservacionSprintProyectoArea = servicioEliminarObservacionSprintProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarObservacionSprintProyectoArea.ejecutarEliminar(codigo));
    }
}
