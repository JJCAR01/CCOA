package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionSprintProyectoArea implements MapeadorAplicacion<DtoSprintProyectoArea, SprintProyectoArea> {
    @Override
    public SprintProyectoArea mapeadorAplicacion(DtoSprintProyectoArea dto) {
        return SprintProyectoArea.of(dto.getIdSprintProyectoArea(), dto.getDescripcion(), dto.getFechaInicial(),dto.getFechaFinal(),dto.getIdProyectoArea());
    }
    public SprintProyectoArea mapeadorAplicacionDuplicar(DtoSprintProyectoArea dto, Long idProyectoArea, LocalDate fechaInicial, LocalDate fechaFinal) {
        return SprintProyectoArea.of(dto.getIdSprintProyectoArea(), dto.getDescripcion(),fechaInicial,fechaFinal,idProyectoArea);
    }
}
