package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionActividadGestionEstrategica implements MapeadorAplicacion<DtoObservacionActividadGestionEstrategica,
        ObservacionActividadGestionEstrategica> {
    @Override
    public ObservacionActividadGestionEstrategica mapeadorAplicacion(DtoObservacionActividadGestionEstrategica dto) {
            return new ObservacionActividadGestionEstrategica(dto.getIdObservacionActividadGestionEstrategica(), dto.getIdActividadGestionEstrategica(),dto.getFecha(), dto.getNombre());
    }
}
