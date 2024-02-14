package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.MapeadorAplicacionObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.observacion.ServicioGuardarObservacionSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionSprintProyectoArea {
    private final ServicioGuardarObservacionSprintProyectoArea servicioGuardarObservacionSprintProyectoArea;
    private final MapeadorAplicacionObservacionSprintProyectoArea mapeadorAplicacionObservacionSprintProyectoArea;

    public ServicioAplicacionGuardarObservacionSprintProyectoArea (ServicioGuardarObservacionSprintProyectoArea servicioGuardarObservacionSprintProyectoArea,
                                                                              MapeadorAplicacionObservacionSprintProyectoArea mapeadorAplicacionObservacionSprintProyectoArea) {
        this.servicioGuardarObservacionSprintProyectoArea = servicioGuardarObservacionSprintProyectoArea;
        this.mapeadorAplicacionObservacionSprintProyectoArea = mapeadorAplicacionObservacionSprintProyectoArea;
    }
    public DtoRespuesta<Long> ejecutar(DtoObservacionSprintProyectoArea dto){
        var observacion = this.mapeadorAplicacionObservacionSprintProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionSprintProyectoArea.ejecutarGuardar(observacion));
    }
}
