package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion.ServicioModificarObservacionPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionPat {

    private final ServicioModificarObservacionPat servicioModificarObservacionPat;
    private final MapeadorAplicacionObservacionPat mapeadorAplicacionObservacionPat;

    public ServicioAplicacionModificarObservacionPat(ServicioModificarObservacionPat servicioModificarObservacionPat, MapeadorAplicacionObservacionPat mapeadorAplicacionObservacionPat) {
        this.servicioModificarObservacionPat = servicioModificarObservacionPat;
        this.mapeadorAplicacionObservacionPat = mapeadorAplicacionObservacionPat;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionPat dto, Long codigo){
        var observacionPat = this.mapeadorAplicacionObservacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionPat.ejecutarModificar(observacionPat,codigo));
    }
}
