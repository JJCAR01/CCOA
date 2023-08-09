package com.ccoa.planeacionestrategica.aplicacion.servicio.area;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
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
