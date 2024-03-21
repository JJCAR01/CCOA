package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
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
    private final MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica;

    public ServicioAplicacionModificarActividadGestionEstrategica(ServicioModificarActividadGestionEstrategica servicioModificarActividadGestionEstrategica,
                                                                  MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica, MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica, MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica) {
        this.servicioModificarActividadGestionEstrategica = servicioModificarActividadGestionEstrategica;
        this.mapeadorAplicacionActividadGestionEstrategica = mapeadorAplicacionActividadGestionEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionEstrategica = mapeadorAplicacionInformacionActividadGestionEstrategica;
        this.mapeadorAplicacionDocumentoActividadGestionEstrategica = mapeadorAplicacionDocumentoActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadGestionEstrategica dto, Long codigo){
        var gestion = this.mapeadorAplicacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        var gestionInf = this.mapeadorAplicacionInformacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarActividadGestionEstrategica.ejecutarModificar(gestion,gestionInf,codigo));
    }
    public DtoRespuesta<Long> modificarDocumento(DtoDocumentoActividadGestionEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestionEstrategica.mapeadorAplicacionModificar(dto,codigo);
        return new DtoRespuesta<>(this.servicioModificarActividadGestionEstrategica.modificarDocumento(documento,codigo));
    }
}
