package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioGuardarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTarea {
    private final ServicioGuardarTarea servicioGuardarTarea;
    private final MapeadorAplicacionTarea mapeadorAplicacionTarea;

    public ServicioAplicacionGuardarTarea(ServicioGuardarTarea servicioGuardarTarea, MapeadorAplicacionTarea mapeadorAplicacionTarea) {
        this.servicioGuardarTarea = servicioGuardarTarea;
        this.mapeadorAplicacionTarea = mapeadorAplicacionTarea;
    }

    public DtoRespuesta<Long> ejecutar(DtoTarea dto){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardar(tarea));
    }
}
