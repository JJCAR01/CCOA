package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.ServicioModificarActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestionActividadEstrategica  {
    private final ServicioModificarActividadGestionActividadEstrategica servicioModificarActividadGestionActividadEstrategica;
    private final MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica;

    public ServicioAplicacionModificarActividadGestionActividadEstrategica(ServicioModificarActividadGestionActividadEstrategica servicioModificarActividadGestionActividadEstrategica,
                                                                           MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica) {
        this.servicioModificarActividadGestionActividadEstrategica = servicioModificarActividadGestionActividadEstrategica;
        this.mapeadorAplicacionActividadGestionActividadEstrategica = mapeadorAplicacionActividadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestionActividadEstrategica dto, Long codigo){
        var gestion= this.mapeadorAplicacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestionActividadEstrategica.ejecutarModificar(gestion,codigo));
    }
}
