package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.ServicioEliminarSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarSprintProyectoArea {
    private final ServicioEliminarSprintProyectoArea servicioEliminarSprintProyectoArea;

    public ServicioAplicacionEliminarSprintProyectoArea(ServicioEliminarSprintProyectoArea servicioEliminarSprintProyectoArea) {
        this.servicioEliminarSprintProyectoArea = servicioEliminarSprintProyectoArea;
    }
    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarSprintProyectoArea.ejecutarEliminar(codigo));
    }
    public DtoRespuesta<Long> eliminarDocumento(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarSprintProyectoArea.eliminarDocumento(codigo));
    }
}
