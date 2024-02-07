package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.observacion.MapeadorAplicacionObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.observacion.ServicioGuardarObservacionActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionActividadGestionActividadEstrategica {
    private final ServicioGuardarObservacionActividadGestionActividadEstrategica servicioGuardarObservacionActivdidadGestionActividadEstrategica;
    private final MapeadorAplicacionObservacionActividadGestionActividadEstrategica mapeadorAplicacionObservacionActivdidadGestionActividadEstrategica;

    public ServicioAplicacionGuardarObservacionActividadGestionActividadEstrategica(ServicioGuardarObservacionActividadGestionActividadEstrategica servicioGuardarObservacionActivdidadGestionActividadEstrategica,
                                                                                    MapeadorAplicacionObservacionActividadGestionActividadEstrategica mapeadorAplicacionObservacionActivdidadGestionActividadEstrategica) {
        this.servicioGuardarObservacionActivdidadGestionActividadEstrategica = servicioGuardarObservacionActivdidadGestionActividadEstrategica;
        this.mapeadorAplicacionObservacionActivdidadGestionActividadEstrategica = mapeadorAplicacionObservacionActivdidadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionActividadGestionActividadEstrategica dto){
        var observacion = this.mapeadorAplicacionObservacionActivdidadGestionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionActivdidadGestionActividadEstrategica.ejecutarGuardar(observacion));
    }
}
