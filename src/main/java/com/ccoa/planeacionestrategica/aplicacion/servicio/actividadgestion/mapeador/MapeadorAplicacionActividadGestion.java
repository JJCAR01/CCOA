package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionActividadGestion implements MapeadorAplicacion<DtoActividadGestion, ActividadGestion> {
    @Override
    public ActividadGestion mapeadorAplicacion(DtoActividadGestion dto) {
        return ActividadGestion.of(dto.getIdActividadGestion(),dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),
                dto.getIdUsuario(), dto.getIdPat());
    }
}
