package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionActividadGestion implements MapeadorAplicacion<DtoObservacionActividadGestion,
        ObservacionActividadGestion> {
    @Override
    public ObservacionActividadGestion mapeadorAplicacion(DtoObservacionActividadGestion dto) {
            return new ObservacionActividadGestion(dto.getIdObservacionActividadGestion(), dto.getIdActividadGestion(),dto.getFecha(), dto.getDescripcion());
    }
}
