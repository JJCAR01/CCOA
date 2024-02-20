package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.observacion.MapeadorAplicacionObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion.ServicioGuardarObservacionSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionSprint {
    private final ServicioGuardarObservacionSprint servicioGuardarObservacionSprint;
    private final MapeadorAplicacionObservacionSprint mapeadorAplicacionObservacionSprint;

    public ServicioAplicacionGuardarObservacionSprint(ServicioGuardarObservacionSprint servicioGuardarObservacionSprint,
                                                      MapeadorAplicacionObservacionSprint mapeadorAplicacionObservacionSprint) {
        this.servicioGuardarObservacionSprint = servicioGuardarObservacionSprint;
        this.mapeadorAplicacionObservacionSprint = mapeadorAplicacionObservacionSprint;
    }
    public DtoRespuesta<Long> ejecutar(DtoObservacionSprint dto){
        var observacion = this.mapeadorAplicacionObservacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionSprint.ejecutarGuardar(observacion));
    }
}
