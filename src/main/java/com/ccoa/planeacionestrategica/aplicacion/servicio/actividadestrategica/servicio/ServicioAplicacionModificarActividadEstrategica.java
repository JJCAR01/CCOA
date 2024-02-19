package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
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
    private final MapeadorAplicacionDetalleActividadEstrategica mapeadorAplicacionDetalleActividadEstrategica;

    public ServicioAplicacionModificarActividadEstrategica(ServicioModificarActividadEstrategica servicioModificarActividadEstrategica,
                                                           MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica, MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica, MapeadorAplicacionDetalleActividadEstrategica mapeadorAplicacionDetalleActividadEstrategica) {
        this.servicioModificarActividadEstrategica = servicioModificarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
        this.mapeadorAplicacionDetalleActividadEstrategica = mapeadorAplicacionDetalleActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadEstrategica dto, Long codigo){
        var actividadEstrategica = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var infActividadEstrategica = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);
        var detalleActividadEstrategica = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.ejecutarModificar(actividadEstrategica,infActividadEstrategica,detalleActividadEstrategica,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarEntregable(DtoActividadEstrategica dto, Long codigo){
        var detalleActividadEstrategica = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorModificarEntregable(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.modificarEntregable(detalleActividadEstrategica,codigo));
    }
    public DtoRespuesta<Long> ejecutarModificarResultadoMeta(DtoActividadEstrategica dto, Long codigo){
        var detalleActividadEstrategica = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorModificarResultadoMeta(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.modificarResultadoMeta(detalleActividadEstrategica,codigo));
    }
}
