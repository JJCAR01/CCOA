package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.observacion.MapeadorAplicacionObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion.ServicioGuardarObservacionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionActividadEstrategica {
    private final ServicioGuardarObservacionActividadEstrategica servicioGuardarObservacionActividadEstrategica;
    private final MapeadorAplicacionObservacionActividadEstrategica mapeadorAplicacionObservacionActividadEstrategica;

    public ServicioAplicacionGuardarObservacionActividadEstrategica(ServicioGuardarObservacionActividadEstrategica servicioGuardarObservacionActividadEstrategica,
                                                                    MapeadorAplicacionObservacionActividadEstrategica mapeadorAplicacionObservacionActividadEstrategica) {
        this.servicioGuardarObservacionActividadEstrategica = servicioGuardarObservacionActividadEstrategica;
        this.mapeadorAplicacionObservacionActividadEstrategica = mapeadorAplicacionObservacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionActividadEstrategica dto){
        var observacion = this.mapeadorAplicacionObservacionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionActividadEstrategica.ejecutarGuardar(observacion));
    }
}
