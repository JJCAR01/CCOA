package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion.ServicioGuardarObservacionTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarObservacionTarea {
    private final ServicioGuardarObservacionTarea servicioGuardarObservacionTarea;
    private final MapeadorAplicacionObservacionTarea mapeadorAplicacionObservacionTarea;

    public ServicioAplicacionGuardarObservacionTarea(ServicioGuardarObservacionTarea servicioGuardarObservacionTarea, MapeadorAplicacionObservacionTarea mapeadorAplicacionObservacionTarea) {
        this.servicioGuardarObservacionTarea = servicioGuardarObservacionTarea;
        this.mapeadorAplicacionObservacionTarea = mapeadorAplicacionObservacionTarea;
    }

    public DtoRespuesta<Long> ejecutar(DtoObservacionTarea dto){
        var observacion = this.mapeadorAplicacionObservacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarObservacionTarea.ejecutarGuardar(observacion));
    }
}
