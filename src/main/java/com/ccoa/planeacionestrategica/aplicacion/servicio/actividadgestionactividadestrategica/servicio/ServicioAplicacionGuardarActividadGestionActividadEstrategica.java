package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.ServicioGuardarActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestionActividadEstrategica  {

    private final ServicioGuardarActividadGestionActividadEstrategica servicioGuardarActividadGestionActividadEstrategica;
    private final MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica;

    public ServicioAplicacionGuardarActividadGestionActividadEstrategica(ServicioGuardarActividadGestionActividadEstrategica servicioGuardarActividadGestionActividadEstrategica, MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica,
                                                                         MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica) {
        this.servicioGuardarActividadGestionActividadEstrategica = servicioGuardarActividadGestionActividadEstrategica;
        this.mapeadorAplicacionActividadGestionActividadEstrategica = mapeadorAplicacionActividadGestionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica = mapeadorAplicacionInformacionActividadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestionActividadEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarActividadGestionActividadEstrategica.ejecutarGuardar(actividad,informacionActividad));
    }
}
