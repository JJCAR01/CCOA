package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoDocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica.ServicioGuardarActividadGestionActividadEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestionActividadEstrategica  {

    private final ServicioGuardarActividadGestionActividadEstrategica servicioGuardarActividadGestionActividadEstrategica;
    private final MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica;
    private final MapeadorAplicacionDocumentoActividadGestionActividadEstrategica mapeadorAplicacionDocumentoActividadGestionActividadEstrategica;

    public ServicioAplicacionGuardarActividadGestionActividadEstrategica(ServicioGuardarActividadGestionActividadEstrategica servicioGuardarActividadGestionActividadEstrategica, MapeadorAplicacionActividadGestionActividadEstrategica mapeadorAplicacionActividadGestionActividadEstrategica,
                                                                         MapeadorAplicacionInformacionActividadGestionActividadEstrategica mapeadorAplicacionInformacionActividadGestionActividadEstrategica, MapeadorAplicacionDocumentoActividadGestionActividadEstrategica mapeadorAplicacionDocumentoActividadGestionActividadEstrategica) {
        this.servicioGuardarActividadGestionActividadEstrategica = servicioGuardarActividadGestionActividadEstrategica;
        this.mapeadorAplicacionActividadGestionActividadEstrategica = mapeadorAplicacionActividadGestionActividadEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica = mapeadorAplicacionInformacionActividadGestionActividadEstrategica;
        this.mapeadorAplicacionDocumentoActividadGestionActividadEstrategica = mapeadorAplicacionDocumentoActividadGestionActividadEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestionActividadEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestionActividadEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionActividadEstrategica.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadGestionActividadEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestionActividadEstrategica.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionActividadEstrategica.ejecutarGuardarDocumento(documento,codigo));
    }
}
