package com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.mapeador.MapeadorAplicacionArea;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioModificarArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarArea {
    private final ServicioModificarArea servicioModificarArea;
    private final MapeadorAplicacionArea mapeadorAplicacionArea;

    public ServicioAplicacionModificarArea(ServicioModificarArea servicioModificarArea, MapeadorAplicacionArea mapeadorAplicacionArea) {
        this.servicioModificarArea = servicioModificarArea;
        this.mapeadorAplicacionArea = mapeadorAplicacionArea;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoArea dto, Long codigo){
        var area = this.mapeadorAplicacionArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarArea.ejecutarModificar(area,codigo));
    }
}
