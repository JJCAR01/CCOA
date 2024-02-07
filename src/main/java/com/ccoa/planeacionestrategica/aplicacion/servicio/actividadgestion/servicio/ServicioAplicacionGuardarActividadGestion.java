package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.documento.MapeadorAplicacionDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionInformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioGuardarActividadGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestion {

    private final ServicioGuardarActividadGestion servicioGuardarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;
    private final MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion;
    private final MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion;

    public ServicioAplicacionGuardarActividadGestion(ServicioGuardarActividadGestion servicioGuardarActividadGestion, MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion,
                                                     MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion, MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion) {
        this.servicioGuardarActividadGestion = servicioGuardarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
        this.mapeadorAplicacionInformacionActividadGestion = mapeadorAplicacionInformacionActividadGestion;
        this.mapeadorAplicacionDocumentoActividadGestion = mapeadorAplicacionDocumentoActividadGestion;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestion dto){
        var actividad = this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadGestion dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestion.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestion.ejecutarGuardarDocumento(documento,codigo));
    }
}
