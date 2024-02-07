package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioGuardarActividadGestionEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestionEstrategica  {

    private final ServicioGuardarActividadGestionEstrategica servicioGuardarActividadGestionEstrategica;
    private final MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica;
    private final MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica;

    public ServicioAplicacionGuardarActividadGestionEstrategica(ServicioGuardarActividadGestionEstrategica servicioGuardarActividadGestionEstrategica, MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica,
                                                                MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica, MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica) {
        this.servicioGuardarActividadGestionEstrategica = servicioGuardarActividadGestionEstrategica;
        this.mapeadorAplicacionActividadGestionEstrategica = mapeadorAplicacionActividadGestionEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionEstrategica = mapeadorAplicacionInformacionActividadGestionEstrategica;
        this.mapeadorAplicacionDocumentoActividadGestionEstrategica = mapeadorAplicacionDocumentoActividadGestionEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestionEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionEstrategica.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadGestionEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestionEstrategica.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionEstrategica.ejecutarGuardarDocumento(documento,codigo));
    }
}
