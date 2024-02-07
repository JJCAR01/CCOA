package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionObservacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoObservacionActividadGestionActividadEstrategica,
        ObservacionActividadGestionActividadEstrategica> {
    @Override
    public ObservacionActividadGestionActividadEstrategica mapeadorAplicacion(DtoObservacionActividadGestionActividadEstrategica dto) {
            return new ObservacionActividadGestionActividadEstrategica(dto.getIdObservacionActividadGestionActividadEstrategica(),
                    dto.getIdActividadGestionActividadEstrategica(),dto.getFecha(), dto.getNombre());
    }
}
