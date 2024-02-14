package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador.MapeadorAplicacionObservacionPat;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.observacion.ServicioGuardarObservacionPat;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionPat {
    private final ServicioGuardarObservacionPat servicioGuardarObservacionPat;
    private final MapeadorAplicacionObservacionPat mapeadorAplicacionObservacionPat;

    public ServicioAplicacionGuardarObservacionPat(ServicioGuardarObservacionPat servicioGuardarObservacionPat,
                                                   MapeadorAplicacionObservacionPat mapeadorAplicacionObservacionPat) {
        this.servicioGuardarObservacionPat = servicioGuardarObservacionPat;
        this.mapeadorAplicacionObservacionPat = mapeadorAplicacionObservacionPat;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionPat dto){
        var observacion = this.mapeadorAplicacionObservacionPat.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionPat.ejecutarGuardar(observacion));
    }
}
