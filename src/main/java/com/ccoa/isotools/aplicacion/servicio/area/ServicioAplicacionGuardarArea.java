package com.ccoa.isotools.aplicacion.servicio.area;

import com.ccoa.isotools.aplicacion.dto.DtoArea;
import com.ccoa.isotools.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.isotools.dominio.modelo.Area;
import com.ccoa.isotools.dominio.servicio.area.ServicioGuardarArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarArea {

    private final ServicioGuardarArea servicioGuardarArea;

    public ServicioAplicacionGuardarArea(ServicioGuardarArea servicioGuardarArea) {
        this.servicioGuardarArea = servicioGuardarArea;
    }

    public DtoRespuesta<Long> ejecutar(DtoArea dto){
        Area area = Area.of(dto.getNombre());
        return new DtoRespuesta<>(this.servicioGuardarArea.ejecutarGuardar(area));
    }
}
