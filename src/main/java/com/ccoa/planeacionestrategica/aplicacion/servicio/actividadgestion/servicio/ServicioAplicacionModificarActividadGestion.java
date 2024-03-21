package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.documento.MapeadorAplicacionDocumentoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.mapeador.MapeadorAplicacionInformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.ServicioModificarActividadGestion;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionModificarActividadGestion {
    private final ServicioModificarActividadGestion servicioModificarActividadGestion;
    private final MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion;
    private final MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion;
    private final MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion;

    public ServicioAplicacionModificarActividadGestion(ServicioModificarActividadGestion servicioModificarActividadGestion,
                                                       MapeadorAplicacionActividadGestion mapeadorAplicacionActividadGestion, MapeadorAplicacionInformacionActividadGestion mapeadorAplicacionInformacionActividadGestion, MapeadorAplicacionDocumentoActividadGestion mapeadorAplicacionDocumentoActividadGestion) {
        this.servicioModificarActividadGestion = servicioModificarActividadGestion;
        this.mapeadorAplicacionActividadGestion = mapeadorAplicacionActividadGestion;
        this.mapeadorAplicacionInformacionActividadGestion = mapeadorAplicacionInformacionActividadGestion;
        this.mapeadorAplicacionDocumentoActividadGestion = mapeadorAplicacionDocumentoActividadGestion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestion dto, Long codigo){
        var gestion = this.mapeadorAplicacionActividadGestion.mapeadorAplicacion(dto);
        var informacion = this.mapeadorAplicacionInformacionActividadGestion.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestion.ejecutarModificar(gestion,informacion,codigo));
    }
    public DtoRespuesta<Long> modificarDocumento(DtoDocumentoActividadGestion dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestion.mapeadorAplicacionModificar(dto,codigo);
        return new DtoRespuesta<>(this.servicioModificarActividadGestion.modificarDocumento(documento,codigo));
    }
}
