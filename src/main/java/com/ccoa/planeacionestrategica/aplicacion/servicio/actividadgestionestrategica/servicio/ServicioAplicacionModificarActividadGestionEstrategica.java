package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioModificarActividadGestionEstrategica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestionEstrategica  {
    private final ServicioModificarActividadGestionEstrategica servicioModificarActividadGestionEstrategica;
    private final MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica;

    public ServicioAplicacionModificarActividadGestionEstrategica(ServicioModificarActividadGestionEstrategica servicioModificarActividadGestionEstrategica,
                                                                  MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica, MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica) {
        this.servicioModificarActividadGestionEstrategica = servicioModificarActividadGestionEstrategica;
        this.mapeadorAplicacionActividadGestionEstrategica = mapeadorAplicacionActividadGestionEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionEstrategica = mapeadorAplicacionInformacionActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestionEstrategica dto, Long codigo){
        var gestion = this.mapeadorAplicacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        var gestionInf = this.mapeadorAplicacionInformacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestionEstrategica.ejecutarModificar(gestion,gestionInf,codigo));
    }
}
