package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.observacion.MapeadorAplicacionObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion.ServicioGuardarObservacionActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionActividadGestion {
    private final ServicioGuardarObservacionActividadGestion servicioGuardarObservacionActivdidadGestion;
    private final MapeadorAplicacionObservacionActividadGestion mapeadorAplicacionObservacionActivdidadGestion;

    public ServicioAplicacionGuardarObservacionActividadGestion(ServicioGuardarObservacionActividadGestion servicioGuardarObservacionActivdidadGestion,
                                                                MapeadorAplicacionObservacionActividadGestion mapeadorAplicacionObservacionActivdidadGestion) {
        this.servicioGuardarObservacionActivdidadGestion = servicioGuardarObservacionActivdidadGestion;
        this.mapeadorAplicacionObservacionActivdidadGestion = mapeadorAplicacionObservacionActivdidadGestion;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionActividadGestion dto){
        var observacion = this.mapeadorAplicacionObservacionActivdidadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionActivdidadGestion.ejecutarGuardar(observacion));
    }
}
