package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.MapeadorAplicacionInformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.ServicioGuardarActividadEstrategica;
import org.springframework.stereotype.Component;
@Component
public class ServicioAplicacionGuardarActividadEstrategica {

    private final ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica;
    private final MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica;
    private final MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica;

    public ServicioAplicacionGuardarActividadEstrategica(ServicioGuardarActividadEstrategica servicioGuardarActividadEstrategica, MapeadorAplicacionActividadEstrategica mapeadorAplicacionActividadEstrategica,
                                                         MapeadorAplicacionInformacionActividadEstrategica mapeadorAplicacionInformacionActividadEstrategica, MapeadorAplicacionDocumentoActividadEstrategica mapeadorAplicacionDocumentoActividadEstrategica) {
        this.servicioGuardarActividadEstrategica = servicioGuardarActividadEstrategica;
        this.mapeadorAplicacionActividadEstrategica = mapeadorAplicacionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadEstrategica = mapeadorAplicacionInformacionActividadEstrategica;
        this.mapeadorAplicacionDocumentoActividadEstrategica = mapeadorAplicacionDocumentoActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadEstrategica.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadEstrategica.ejecutarGuardarDocumento(documento,codigo));
    }
}
