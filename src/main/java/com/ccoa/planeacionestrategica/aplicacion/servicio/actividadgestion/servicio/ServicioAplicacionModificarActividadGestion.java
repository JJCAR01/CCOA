package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionInformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioModificarActividadGestion;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestion {
    private final ServicioModificarActividadGestion servicioModificarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;
    private final MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion;

    public ServicioAplicacionModificarActividadGestion(ServicioModificarActividadGestion servicioModificarActividadGestion,
                                                       MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion, MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion) {
        this.servicioModificarActividadGestion = servicioModificarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
        this.mapeadorAplicacionInformacionActividadGestion = mapeadorAplicacionInformacionActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestion dto, Long codigo){
        var gestion = this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        var informacion = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestion.ejecutarModificar(gestion,informacion,codigo));
    }
}
