package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.observacion.MapeadorAplicacionObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion.ServicioModificarObservacionActividadGestionEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionActividadGestionEstrategica {

    private final ServicioModificarObservacionActividadGestionEstrategica servicioModificarObservacionActividadGestionEstrategica;
    private final MapeadorAplicacionObservacionActividadGestionEstrategica mapeadorAplicacionObservacionActividadGestionEstrategica;

    public ServicioAplicacionModificarObservacionActividadGestionEstrategica(ServicioModificarObservacionActividadGestionEstrategica servicioModificarObservacionActividadGestionEstrategica,
                                                                             MapeadorAplicacionObservacionActividadGestionEstrategica mapeadorAplicacionObservacionActividadGestionEstrategica) {
        this.servicioModificarObservacionActividadGestionEstrategica = servicioModificarObservacionActividadGestionEstrategica;
        this.mapeadorAplicacionObservacionActividadGestionEstrategica = mapeadorAplicacionObservacionActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionActividadGestionEstrategica dto, Long codigo){
        var observacionActividadGestionEstrategica = this.mapeadorAplicacionObservacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionActividadGestionEstrategica.ejecutarModificar(observacionActividadGestionEstrategica,codigo));
    }
}
