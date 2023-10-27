package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.ServicioModificarActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestionActividadEstrategica  {
    private final ServicioModificarActividadGestionActividadEstrategica servicioModificarActividadGestionActividadEstrategica;
    private final MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica;

    public ServicioAplicacionModificarActividadGestionActividadEstrategica(ServicioModificarActividadGestionActividadEstrategica servicioModificarActividadGestionActividadEstrategica,
                                                                           MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica, MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica) {
        this.servicioModificarActividadGestionActividadEstrategica = servicioModificarActividadGestionActividadEstrategica;
        this.mapeadorAplicacionActividadGestionActividadEstrategica = mapeadorAplicacionActividadGestionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica = mapeadorAplicacionInformacionActividadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestionActividadEstrategica dto, Long codigo){
        var gestion= this.mapeadorAplicacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        var gestionInf = this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestionActividadEstrategica.ejecutarModificar(gestion,gestionInf,codigo));
    }
}
