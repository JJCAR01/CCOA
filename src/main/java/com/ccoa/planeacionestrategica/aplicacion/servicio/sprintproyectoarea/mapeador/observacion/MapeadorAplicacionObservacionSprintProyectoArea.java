package com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionSprintProyectoArea implements MapeadorAplicacion<DtoObservacionSprintProyectoArea, ObservacionSprintProyectoArea> {
    @Override
    public ObservacionSprintProyectoArea mapeadorAplicacion(DtoObservacionSprintProyectoArea dto) {
            return new ObservacionSprintProyectoArea(dto.getIdObservacionSprintProyectoArea(), dto.getIdSprintProyectoArea(),dto.getFecha(), dto.getDescripcion());
    }
}
