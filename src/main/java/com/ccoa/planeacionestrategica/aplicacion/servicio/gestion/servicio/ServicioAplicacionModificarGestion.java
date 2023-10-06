package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.mapeador.MapeadorAplicacionGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioModificarGestion;
import org.springframework.stereotype.Component;


@Component
public class ServicioAplicacionModificarGestion {
    private final ServicioModificarGestion servicioModificarGestion;
    private final MapeadorAplicacionGestion mapeadorAplicacionGestion;
    public ServicioAplicacionModificarGestion(ServicioModificarGestion servicioModificarGestion, MapeadorAplicacionGestion mapeadorAplicacionGestion) {
        this.servicioModificarGestion = servicioModificarGestion;
        this.mapeadorAplicacionGestion = mapeadorAplicacionGestion;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoGestion dto, Long codigo){
        var gestion= this.mapeadorAplicacionGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarGestion.ejecutarModificar(gestion,codigo));
    }
}
