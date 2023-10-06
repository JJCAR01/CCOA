package com.ccoa.planeacionestrategica.aplicacion.servicio.area.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionArea implements MapeadorAplicacion<DtoArea, Area> {
    @Override
    public Area mapeadorAplicacion(DtoArea dto) {
        return new Area(dto.getIdArea(), dto.getNombre());
    }
}
