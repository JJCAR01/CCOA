package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividad.DtoActividad;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionInformacionActividad implements MapeadorAplicacion<DtoActividad, InformacionActividad> {
    @Override
    public InformacionActividad mapeadorAplicacion(DtoActividad dto) {
        return new InformacionActividad(dto.getIdInformacionActividad(), dto.getDuracion(),dto.getDiasRestantes(),
                dto.getAvance(), dto.getIdEpica(), dto.getIdGestion());
    }
}
