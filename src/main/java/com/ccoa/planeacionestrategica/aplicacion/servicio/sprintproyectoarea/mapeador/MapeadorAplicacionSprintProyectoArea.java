package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionSprintProyectoArea implements MapeadorAplicacion<DtoSprintProyectoArea, SprintProyectoArea> {
    @Override
    public SprintProyectoArea mapeadorAplicacion(DtoSprintProyectoArea dto) {
        return new SprintProyectoArea(dto.getIdSprintProyectoArea(), dto.getDescripcion(), dto.getFechaInicial(),dto.getFechaFinal(),dto.getIdProyectoArea());
    }
}
