package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionSprint implements MapeadorAplicacion<DtoObservacionSprint, ObservacionSprint> {
    @Override
    public ObservacionSprint mapeadorAplicacion(DtoObservacionSprint dto) {
            return ObservacionSprint.of(dto.getIdObservacionSprint(), dto.getIdSprint(),dto.getFecha(), dto.getDescripcion());
    }
}
