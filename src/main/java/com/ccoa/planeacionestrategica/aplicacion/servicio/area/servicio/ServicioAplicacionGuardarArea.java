package com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.area.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.mapeador.MapeadorAplicacionArea;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarArea {

    private final ServicioGuardarArea servicioGuardarArea;
    private final MapeadorAplicacionArea mapeadorAplicacionArea;

    public ServicioAplicacionGuardarArea(ServicioGuardarArea servicioGuardarArea, MapeadorAplicacionArea mapeadorAplicacionArea) {
        this.servicioGuardarArea = servicioGuardarArea;
        this.mapeadorAplicacionArea = mapeadorAplicacionArea;
    }

    public DtoRespuesta<Long> ejecutar(DtoArea dto){
        var area = this.mapeadorAplicacionArea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarArea.ejecutarGuardar(area));
    }
}
