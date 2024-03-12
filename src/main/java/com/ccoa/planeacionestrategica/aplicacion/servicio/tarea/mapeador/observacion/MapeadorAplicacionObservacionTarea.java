package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionTarea implements MapeadorAplicacion<DtoObservacionTarea, ObservacionTarea> {
    @Override
    public ObservacionTarea mapeadorAplicacion(DtoObservacionTarea dto) {
        return new ObservacionTarea(dto.getIdObservacionTarea(), dto.getIdTarea(),dto.getFecha(), dto.getDescripcion());
    }
}
