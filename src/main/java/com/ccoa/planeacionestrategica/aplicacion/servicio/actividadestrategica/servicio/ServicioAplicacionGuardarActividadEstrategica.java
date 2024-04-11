package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionDetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioGuardarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionGuardarActividadEstrategica {

    private final ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica;
    private final MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica;
    private final MapeadorAplicacionDetalleActividadEstrategica mapeadorAplicacionDetalleActividadEstrategica;
    private final MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarActividadEstrategica(ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica, MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica,
                                                         MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica, MapeadorAplicacionDetalleActividadEstrategica mapeadorAplicacionDetalleActividadEstrategica, MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarActividadEstrategica = servicioGuardarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
        this.mapeadorAplicacionDetalleActividadEstrategica = mapeadorAplicacionDetalleActividadEstrategica;
        this.mapeadorAplicacionDocumentoActividadEstrategica = mapeadorAplicacionDocumentoActividadEstrategica;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);
        var detalleActividad = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardar(actividad,informacionActividad,detalleActividad));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoActividadEstrategica dto,Long idPat,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var actividad = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacionDuplicar(dto,idPat,fechaInicial,fechaFinal);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacionDuplicar(dto,fechaInicial,fechaFinal);
        var detalleActividad = this.mapeadorAplicacionDetalleActividadEstrategica.mapeadorAplicacionDuplicar();

        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardarDuplicado(actividad,informacionActividad,detalleActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadEstrategica.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardarDocumento(documento,codigo));
    }
}
