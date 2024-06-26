package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapeadorAplicacionSprint implements MapeadorAplicacion<DtoSprint, Sprint> {
    @Override
    public Sprint mapeadorAplicacion(DtoSprint dto) {
        return Sprint.of(dto.getIdSprint(), dto.getDescripcion(), dto.getFechaInicial(),dto.getFechaFinal(),dto.getIdProyecto());
    }
    public Sprint mapeadorAplicacionDuplicar(DtoSprint dto, Long idProyecto, LocalDate fechaInicial, LocalDate fechaFinal) {
        return Sprint.of(dto.getIdSprint(), dto.getDescripcion(), fechaInicial,fechaFinal,idProyecto);
    }
}
