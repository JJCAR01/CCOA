package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.observacion.MapeadorAplicacionObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion.ServicioModificarObservacionTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarObservacionTarea {

    private final ServicioModificarObservacionTarea servicioModificarObservacionTarea;
    private final MapeadorAplicacionObservacionTarea mapeadorAplicacionObservacionTarea;

    public ServicioAplicacionModificarObservacionTarea(ServicioModificarObservacionTarea servicioModificarObservacionTarea,
                                                       MapeadorAplicacionObservacionTarea mapeadorAplicacionObservacionTarea) {
        this.servicioModificarObservacionTarea = servicioModificarObservacionTarea;
        this.mapeadorAplicacionObservacionTarea = mapeadorAplicacionObservacionTarea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoObservacionTarea dto, Long codigo){
        var observacionTarea = this.mapeadorAplicacionObservacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarObservacionTarea.ejecutarModificar(observacionTarea,codigo));
    }
}
