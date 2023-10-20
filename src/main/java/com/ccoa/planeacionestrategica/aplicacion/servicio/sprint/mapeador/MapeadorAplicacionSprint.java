package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionSprint implements MapeadorAplicacion<DtoSprint, Sprint> {
    @Override
    public Sprint mapeadorAplicacion(DtoSprint dto) {
        return new Sprint(dto.getIdSprint(), dto.getDescripcion(), dto.getFechaInicial(),dto.getFechaFinal(),dto.getAvance(),
                dto.getEstado(), dto.getIdProyecto());
    }
}
