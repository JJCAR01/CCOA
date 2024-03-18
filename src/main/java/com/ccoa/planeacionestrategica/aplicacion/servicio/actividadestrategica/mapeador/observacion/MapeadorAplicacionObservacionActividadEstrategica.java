package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionActividadEstrategica implements MapeadorAplicacion<DtoObservacionActividadEstrategica,
        ObservacionActividadEstrategica> {
    @Override
    public ObservacionActividadEstrategica mapeadorAplicacion(DtoObservacionActividadEstrategica dto) {
            return ObservacionActividadEstrategica.of(dto.getIdObservacionActividadEstrategica(), dto.getIdActividadEstrategica(),dto.getFecha(), dto.getDescripcion());
    }
}
