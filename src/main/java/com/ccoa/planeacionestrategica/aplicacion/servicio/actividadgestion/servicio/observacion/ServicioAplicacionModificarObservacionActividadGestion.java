package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.observacion.MapeadorAplicacionObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion.ServicioModificarObservacionActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionActividadGestion {

    private final ServicioModificarObservacionActividadGestion servicioModificarObservacionActividadGestion;
    private final MapeadorAplicacionObservacionActividadGestion mapeadorAplicacionObservacionActividadGestion;

    public ServicioAplicacionModificarObservacionActividadGestion(ServicioModificarObservacionActividadGestion servicioModificarObservacionActividadGestion,
                                                                  MapeadorAplicacionObservacionActividadGestion mapeadorAplicacionObservacionActividadGestion) {
        this.servicioModificarObservacionActividadGestion = servicioModificarObservacionActividadGestion;
        this.mapeadorAplicacionObservacionActividadGestion = mapeadorAplicacionObservacionActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionActividadGestion dto, Long codigo){
        var observacionActividadGestion = this.mapeadorAplicacionObservacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionActividadGestion.ejecutarModificar(observacionActividadGestion,codigo));
    }
}
