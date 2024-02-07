package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionInformacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioGuardarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTarea {
    private final ServicioGuardarTarea servicioGuardarTarea;
    private final MapeadorAplicacionTarea mapeadorAplicacionTarea;
    private final MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea;

    public ServicioAplicacionGuardarTarea(ServicioGuardarTarea servicioGuardarTarea, MapeadorAplicacionTarea mapeadorAplicacionTarea, MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea) {
        this.servicioGuardarTarea = servicioGuardarTarea;
        this.mapeadorAplicacionTarea = mapeadorAplicacionTarea;
        this.mapeadorAplicacionInformacionTarea = mapeadorAplicacionInformacionTarea;
    }

    public DtoRespuesta<Long> ejecutar(DtoTarea dto){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacion(dto);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarTarea.ejecutarGuardar(tarea,informacionTarea));
    }
}
