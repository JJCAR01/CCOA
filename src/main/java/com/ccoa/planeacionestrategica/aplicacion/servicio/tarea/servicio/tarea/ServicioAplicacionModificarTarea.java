package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionInformacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.mapeador.MapeadorAplicacionTarea;
import com.ccoa.planeacionestrategica.dominio.servicio.tarea.ServicioModificarTarea;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarTarea {
    private final ServicioModificarTarea servicioModificarTarea;
    private final MapeadorAplicacionTarea mapeadorAplicacionTarea;
    private final MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea;

    public ServicioAplicacionModificarTarea(ServicioModificarTarea servicioModificarTarea, MapeadorAplicacionTarea mapeadorAplicacionTarea, MapeadorAplicacionInformacionTarea mapeadorAplicacionInformacionTarea) {
        this.servicioModificarTarea = servicioModificarTarea;
        this.mapeadorAplicacionTarea = mapeadorAplicacionTarea;
        this.mapeadorAplicacionInformacionTarea = mapeadorAplicacionInformacionTarea;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoTarea dto, Long codigo){
        var tarea = this.mapeadorAplicacionTarea.mapeadorAplicacion(dto);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.actualizarEstado(dto);
        return new DtoRespuesta<>(this.servicioModificarTarea.ejecutarModificar(tarea,informacionTarea,codigo));
    }

    public DtoRespuesta<Long> modificarEstado(DtoTarea dto, Long codigo){
        var tarea = this.mapeadorAplicacionTarea.actualizarEstado(dto);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.actualizarEstado(dto);
        return new DtoRespuesta<>(this.servicioModificarTarea.modificarEstado(tarea,informacionTarea,codigo));
    }

    public DtoRespuesta<Long> modificarPorcentaje(DtoTarea dto, Long codigo){
        var tarea = this.mapeadorAplicacionTarea.actualizarPorcentaje(dto);
        var informacionTarea = this.mapeadorAplicacionInformacionTarea.actualizarPorcentaje(dto);
        return new DtoRespuesta<>(this.servicioModificarTarea.modificarPorcentaje(tarea,informacionTarea,codigo));
    }
}
