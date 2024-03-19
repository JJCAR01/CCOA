package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.observacion.MapeadorAplicacionObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion.ServicioModificarObservacionSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionSprintProyectoArea {

    private final ServicioModificarObservacionSprintProyectoArea servicioModificarObservacionSprintProyectoArea;
    private final MapeadorAplicacionObservacionSprintProyectoArea mapeadorAplicacionObservacionSprintProyectoArea;

    public ServicioAplicacionModificarObservacionSprintProyectoArea(ServicioModificarObservacionSprintProyectoArea servicioModificarObservacionSprintProyectoArea,
                                                                    MapeadorAplicacionObservacionSprintProyectoArea mapeadorAplicacionObservacionSprintProyectoArea) {
        this.servicioModificarObservacionSprintProyectoArea = servicioModificarObservacionSprintProyectoArea;
        this.mapeadorAplicacionObservacionSprintProyectoArea = mapeadorAplicacionObservacionSprintProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionSprintProyectoArea dto, Long codigo){
        var observacionSprintProyectoArea = this.mapeadorAplicacionObservacionSprintProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionSprintProyectoArea.ejecutarModificar(observacionSprintProyectoArea,codigo));
    }
}
