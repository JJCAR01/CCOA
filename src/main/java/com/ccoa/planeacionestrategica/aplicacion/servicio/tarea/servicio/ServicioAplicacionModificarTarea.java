package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioModificarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTarea {
    private final ServicioModificarTarea servicioModificarTarea;
    private final MapeadorAplicacionTarea mapeadorAplicacionTarea;

    public ServicioAplicacionModificarTarea(ServicioModificarTarea servicioModificarTarea, MapeadorAplicacionTarea mapeadorAplicacionTarea) {
        this.servicioModificarTarea = servicioModificarTarea;
        this.mapeadorAplicacionTarea = mapeadorAplicacionTarea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTarea dto, Long codigo){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarTarea.ejecutarModificar(tarea,codigo));
    }
}
