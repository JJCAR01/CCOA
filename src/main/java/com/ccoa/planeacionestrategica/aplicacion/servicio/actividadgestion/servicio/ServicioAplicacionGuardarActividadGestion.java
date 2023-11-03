package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionInformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioGuardarActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestion {

    private final ServicioGuardarActividadGestion servicioGuardarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;
    private final MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion;

    public ServicioAplicacionGuardarActividadGestion(ServicioGuardarActividadGestion servicioGuardarActividadGestion, MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion,
                                                     MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion) {
        this.servicioGuardarActividadGestion = servicioGuardarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
        this.mapeadorAplicacionInformacionActividadGestion = mapeadorAplicacionInformacionActividadGestion;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestion dto){
        var actividad = this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardar(actividad,informacionActividad));
    }
}
