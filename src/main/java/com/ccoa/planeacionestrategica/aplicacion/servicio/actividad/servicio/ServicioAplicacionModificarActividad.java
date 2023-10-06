package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividad.DtoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.mapeador.MapeadorAplicacionActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.actividad.ServicioModificarActividad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarActividad {
    private final ServicioModificarActividad servicioModificarActividad;
    private final MapeadorAplicacionActividad mapeadorAplicacionActividad;

    public ServicioAplicacionModificarActividad(ServicioModificarActividad servicioModificarActividad, MapeadorAplicacionActividad mapeadorAplicacionActividad) {
        this.servicioModificarActividad = servicioModificarActividad;
        this.mapeadorAplicacionActividad = mapeadorAplicacionActividad;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividad dto, Long codigo){
        var actividad = this.mapeadorAplicacionActividad.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividad.ejecutarModificar(actividad,codigo));
    }
}
