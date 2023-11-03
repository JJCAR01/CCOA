package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioGuardarActividadEstrategica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionGuardarActividadEstrategica {

    private final ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica;
    private final MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica;

    public ServicioAplicacionGuardarActividadEstrategica(ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica, MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica,
                                                         MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica) {
        this.servicioGuardarActividadEstrategica = servicioGuardarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadEstrategica dto){
        var epica = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var informacionEpica = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardar(epica,informacionEpica));
    }
}
