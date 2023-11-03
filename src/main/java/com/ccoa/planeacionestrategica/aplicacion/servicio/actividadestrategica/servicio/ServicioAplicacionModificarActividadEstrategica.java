package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioModificarActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarActividadEstrategica {
    private final ServicioModificarActividadEstrategica servicioModificarActividadEstrategica;
    private final MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica;

    public ServicioAplicacionModificarActividadEstrategica(ServicioModificarActividadEstrategica servicioModificarActividadEstrategica,
                                                           MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica, MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica) {
        this.servicioModificarActividadEstrategica = servicioModificarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadEstrategica dto, Long codigo){
        var actividadEstrategica = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var infActividadEstrategica = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.ejecutarModificar(actividadEstrategica,infActividadEstrategica,codigo));
    }
}
