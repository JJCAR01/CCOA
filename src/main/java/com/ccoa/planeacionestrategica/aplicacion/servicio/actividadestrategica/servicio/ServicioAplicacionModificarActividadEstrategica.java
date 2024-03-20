package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadEstrategica;
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
    private final MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica;

    public ServicioAplicacionModificarActividadEstrategica(ServicioModificarActividadEstrategica servicioModificarActividadEstrategica,
                                                           MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica,
                                                           MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica, MapeadorAplicacionDetalleActividadEstrategica mapeadorAplicacionDetalleActividadEstrategica, MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica) {
        this.servicioModificarActividadEstrategica = servicioModificarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
        this.mapeadorAplicacionDetalleActividadEstrategica = mapeadorAplicacionDetalleActividadEstrategica;
        this.mapeadorAplicacionDocumentoActividadEstrategica = mapeadorAplicacionDocumentoActividadEstrategica;
    }

    public DtoRespuesta<Long> modificarActividadEstrategica(DtoActividadEstrategica dto, Long codigo){
        var actividadEstrategica = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var infActividadEstrategica = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);
        var detalleActividadEstrategica = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.ejecutarModificar(actividadEstrategica,infActividadEstrategica,detalleActividadEstrategica,codigo));
    }
    public DtoRespuesta<Long> modificarResultadoMeta(DtoActividadEstrategica dto, Long codigo){
        var detalleActividadEstrategica = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorModificarResultadoMeta(dto);
        var infoActividadEstrategica = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacionActualizarPorcentaje(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.modificarResultadoMeta(detalleActividadEstrategica,infoActividadEstrategica,codigo));
    }
    public DtoRespuesta<Long> modificarDocumento(DtoDocumentoActividadEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadEstrategica.mapeadorAplicacionModificar(dto,codigo);
        return new DtoRespuesta<>(this.servicioModificarActividadEstrategica.modificarDocumento(documento,codigo));
    }
}
