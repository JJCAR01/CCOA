package com.ccoa.planeacionestrategica.aplicacion.servicio.area.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.area.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.area.Area;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionArea implements MapeadorAplicacion<DtoArea, Area> {
    @Override
    public Area mapeadorAplicacion(DtoArea dto) {

        return Area.of(dto.getIdArea(), dto.getNombre(), dto.getDireccion());
    }
}
