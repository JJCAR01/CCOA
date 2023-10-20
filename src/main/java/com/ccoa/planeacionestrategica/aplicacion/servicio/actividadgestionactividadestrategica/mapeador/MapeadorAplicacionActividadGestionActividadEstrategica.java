package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionActividadGestionActividadEstrategica implements MapeadorAplicacion<DtoActividadGestionActividadEstrategica, ActividadGestionActividadEstrategica> {
    @Override
    public ActividadGestionActividadEstrategica mapeadorAplicacion(DtoActividadGestionActividadEstrategica dto) {
        return new ActividadGestionActividadEstrategica(dto.getIdActividadGestionActividadEstrategica(),dto.getNombre(), dto.getFechaInicial(),dto.getFechaFinal(),
                dto.getIdUsuario(), dto.getIdActividadEstrategica());
    }
}
