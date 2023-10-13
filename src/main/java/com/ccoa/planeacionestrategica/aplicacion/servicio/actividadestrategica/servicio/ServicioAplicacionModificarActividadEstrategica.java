package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioModificarActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarActividadEstrategica {
    private final ServicioModificarActividadEstrategica servicioModificarActividadEstrategica;
    private final MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica;

    public ServicioAplicacionModificarActividadEstrategica(ServicioModificarActividadEstrategica servicioModificarActividadEstrategica,
                                                           MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica) {
        this.servicioModificarActividadEstrategica = servicioModificarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadEstrategica dto, Long codigo){
        var epica = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.ejecutarModificar(epica,codigo));
    }
}
