package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioModificarActividadGestion;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestion {
    private final ServicioModificarActividadGestion servicioModificarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;

    public ServicioAplicacionModificarActividadGestion(ServicioModificarActividadGestion servicioModificarActividadGestion,
                                                       MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion) {
        this.servicioModificarActividadGestion = servicioModificarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestion dto, Long codigo){
        var gestion= this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestion.ejecutarModificar(gestion,codigo));
    }
}
