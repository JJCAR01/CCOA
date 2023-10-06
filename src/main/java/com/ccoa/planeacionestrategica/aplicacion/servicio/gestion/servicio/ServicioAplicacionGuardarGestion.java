package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.mapeador.MapeadorAplicacionGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioGuardarGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarGestion {

    private final ServicioGuardarGestion servicioGuardarGestion;
    private final MapeadorAplicacionGestion mapeadorAplicacionGestion;

    public ServicioAplicacionGuardarGestion(ServicioGuardarGestion servicioGuardarGestion, MapeadorAplicacionGestion mapeadorAplicacionGestion) {
        this.servicioGuardarGestion = servicioGuardarGestion;
        this.mapeadorAplicacionGestion = mapeadorAplicacionGestion;
    }

    public DtoRespuesta<Long> ejecutar(DtoGestion dto){
        var gestion = this.mapeadorAplicacionGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarGestion.ejecutarGuardar(gestion));
    }
}
