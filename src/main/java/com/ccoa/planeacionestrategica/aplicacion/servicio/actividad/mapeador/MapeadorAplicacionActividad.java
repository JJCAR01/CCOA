package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividad.DtoActividad;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionActividad implements MapeadorAplicacion<DtoActividad, Actividad> {
    @Override
    public Actividad mapeadorAplicacion(DtoActividad dto) {
        return new Actividad(dto.getIdActividad(), dto.getTipoActividad(), dto.getFechaInicial(),dto.getFechaFinal(),
                dto.getIdInformacionActividad());
    }
}
