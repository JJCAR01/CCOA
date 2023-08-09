package com.ccoa.isotools.aplicacion.servicio.area;

import com.ccoa.isotools.aplicacion.dto.DtoArea;
import com.ccoa.isotools.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.isotools.dominio.modelo.Area;
import com.ccoa.isotools.dominio.servicio.area.ServicioModificarArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarArea {

    private final ServicioModificarArea servicioModificarArea;

    public ServicioAplicacionModificarArea(ServicioModificarArea servicioModificarArea) {
        this.servicioModificarArea = servicioModificarArea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoArea dto, Long codigo){
        Area area = Area.of(dto.getNombre());

        return new DtoRespuesta<>(this.servicioModificarArea.ejecutarModificar(area,codigo));
    }
}
