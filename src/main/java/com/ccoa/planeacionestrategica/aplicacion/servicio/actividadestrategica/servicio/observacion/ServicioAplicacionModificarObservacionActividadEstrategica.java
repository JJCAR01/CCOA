package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.observacion.MapeadorAplicacionObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion.ServicioModificarObservacionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionActividadEstrategica {

    private final ServicioModificarObservacionActividadEstrategica servicioModificarObservacionActividadEstrategica;
    private final MapeadorAplicacionObservacionActividadEstrategica mapeadorAplicacionObservacionActividadEstrategica;

    public ServicioAplicacionModificarObservacionActividadEstrategica(ServicioModificarObservacionActividadEstrategica servicioModificarObservacionActividadEstrategica,
                                                                      MapeadorAplicacionObservacionActividadEstrategica mapeadorAplicacionObservacionActividadEstrategica) {
        this.servicioModificarObservacionActividadEstrategica = servicioModificarObservacionActividadEstrategica;
        this.mapeadorAplicacionObservacionActividadEstrategica = mapeadorAplicacionObservacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionActividadEstrategica dto, Long codigo){
        var observacionActividadEstrategica = this.mapeadorAplicacionObservacionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionActividadEstrategica.ejecutarModificar(observacionActividadEstrategica,codigo));
    }
}
