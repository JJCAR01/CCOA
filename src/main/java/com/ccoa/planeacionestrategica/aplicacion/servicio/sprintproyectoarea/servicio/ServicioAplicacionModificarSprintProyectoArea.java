package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.MapeadorAplicacionInformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.MapeadorAplicacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.sprintproyectoarea.ServicioModificarSprintProyectoArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarSprintProyectoArea {
    private final ServicioModificarSprintProyectoArea servicioModificarSprintProyectoArea;
    private final MapeadorAplicacionSprintProyectoArea mapeadorAplicacionSprintProyectoArea;
    private final MapeadorAplicacionInformacionSprintProyectoArea mapeadorAplicacionInformacionSprintProyectoArea;

    public ServicioAplicacionModificarSprintProyectoArea(ServicioModificarSprintProyectoArea servicioModificarSprintProyectoArea, MapeadorAplicacionSprintProyectoArea mapeadorAplicacionSprintProyectoArea, MapeadorAplicacionInformacionSprintProyectoArea mapeadorAplicacionInformacionSprintProyectoArea) {
        this.servicioModificarSprintProyectoArea = servicioModificarSprintProyectoArea;
        this.mapeadorAplicacionSprintProyectoArea = mapeadorAplicacionSprintProyectoArea;
        this.mapeadorAplicacionInformacionSprintProyectoArea = mapeadorAplicacionInformacionSprintProyectoArea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoSprintProyectoArea dto, Long codigo){
        var sprintProyectoArea = this.mapeadorAplicacionSprintProyectoArea.mapeadorAplicacion(dto);
        var informacionSprintProyectoArea = this.mapeadorAplicacionInformacionSprintProyectoArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarSprintProyectoArea.ejecutarModificar(sprintProyectoArea,informacionSprintProyectoArea,codigo));
    }
}
