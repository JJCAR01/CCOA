package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.observacion.MapeadorAplicacionObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.observacion.ServicioModificarObservacionSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionSprint {

    private final ServicioModificarObservacionSprint servicioModificarObservacionSprint;
    private final MapeadorAplicacionObservacionSprint mapeadorAplicacionObservacionSprint;

    public ServicioAplicacionModificarObservacionSprint(ServicioModificarObservacionSprint servicioModificarObservacionSprint,
                                                        MapeadorAplicacionObservacionSprint mapeadorAplicacionObservacionSprint) {
        this.servicioModificarObservacionSprint = servicioModificarObservacionSprint;
        this.mapeadorAplicacionObservacionSprint = mapeadorAplicacionObservacionSprint;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionSprint dto, Long codigo){
        var observacionSprint = this.mapeadorAplicacionObservacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionSprint.ejecutarModificar(observacionSprint,codigo));
    }
}
