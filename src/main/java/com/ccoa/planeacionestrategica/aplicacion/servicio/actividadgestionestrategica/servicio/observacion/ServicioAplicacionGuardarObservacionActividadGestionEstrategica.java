package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.observacion.MapeadorAplicacionObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion.ServicioGuardarObservacionActividadGestionEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionActividadGestionEstrategica {
    private final ServicioGuardarObservacionActividadGestionEstrategica servicioGuardarObservacionActivdidadGestionEstrategica;
    private final MapeadorAplicacionObservacionActividadGestionEstrategica mapeadorAplicacionObservacionActivdidadGestionEstrategica;

    public ServicioAplicacionGuardarObservacionActividadGestionEstrategica(ServicioGuardarObservacionActividadGestionEstrategica servicioGuardarObservacionActivdidadGestionEstrategica,
                                                                           MapeadorAplicacionObservacionActividadGestionEstrategica mapeadorAplicacionObservacionActivdidadGestionEstrategica) {
        this.servicioGuardarObservacionActivdidadGestionEstrategica = servicioGuardarObservacionActivdidadGestionEstrategica;
        this.mapeadorAplicacionObservacionActivdidadGestionEstrategica = mapeadorAplicacionObservacionActivdidadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionActividadGestionEstrategica dto){
        var observacion = this.mapeadorAplicacionObservacionActivdidadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionActivdidadGestionEstrategica.ejecutarGuardar(observacion));
    }
}
