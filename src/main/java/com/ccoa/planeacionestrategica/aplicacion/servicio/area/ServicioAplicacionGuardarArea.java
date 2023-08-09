package com.ccoa.planeacionestrategica.aplicacion.servicio.area;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
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
