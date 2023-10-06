package com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividad.DtoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.mapeador.MapeadorAplicacionActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.mapeador.MapeadorAplicacionInformacionActividad;
import com.ccoa.planeacionestrategica.dominio.servicio.actividad.ServicioGuardarActividad;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividad {
    private final ServicioGuardarActividad servicioGuardarActividad;
    private final MapeadorAplicacionActividad mapeadorAplicacionActividad;
    private final MapeadorAplicacionInformacionActividad mapeadorAplicacionInformacionActividad;

    public ServicioAplicacionGuardarActividad(ServicioGuardarActividad servicioGuardarActividad, MapeadorAplicacionActividad mapeadorAplicacionActividad,
                                              MapeadorAplicacionInformacionActividad mapeadorAplicacionInformacionActividad) {
        this.servicioGuardarActividad = servicioGuardarActividad;
        this.mapeadorAplicacionActividad = mapeadorAplicacionActividad;
        this.mapeadorAplicacionInformacionActividad = mapeadorAplicacionInformacionActividad;
    }
    public DtoRespuesta<Long> ejecutar(DtoActividad dto){
        var actividad = this.mapeadorAplicacionActividad.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividad.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarActividad.ejecutarGuardar(actividad,informacionActividad));
    }
}
