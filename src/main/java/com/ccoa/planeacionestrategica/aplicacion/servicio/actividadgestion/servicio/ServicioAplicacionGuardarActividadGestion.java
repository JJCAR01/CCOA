package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.documento.MapeadorAplicacionDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionInformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioGuardarActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestion {

    private final ServicioGuardarActividadGestion servicioGuardarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;
    private final MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion;
    private final MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarActividadGestion(ServicioGuardarActividadGestion servicioGuardarActividadGestion, MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion,
                                                     MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion, MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarActividadGestion = servicioGuardarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
        this.mapeadorAplicacionInformacionActividadGestion = mapeadorAplicacionInformacionActividadGestion;
        this.mapeadorAplicacionDocumentoActividadGestion = mapeadorAplicacionDocumentoActividadGestion;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestion dto){
        var actividad = this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoActividadGestion dto,Long idPat,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var actividad = this.mapeadorAplicacionActividadGestion.mapeadorAplicacionDuplicar(dto,idPat,fechaInicial,fechaFinal);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacionDuplicar(fechaInicial,fechaFinal);

        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadGestion dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestion.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardarDocumento(documento,codigo));
    }
}
