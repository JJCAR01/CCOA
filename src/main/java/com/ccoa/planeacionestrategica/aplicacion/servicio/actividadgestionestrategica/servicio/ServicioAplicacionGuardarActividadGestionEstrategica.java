package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.MapeadorAplicacionInformacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.mapeador.documento.MapeadorAplicacionDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.ServicioGuardarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadGestionEstrategica  {

    private final ServicioGuardarActividadGestionEstrategica servicioGuardarActividadGestionEstrategica;
    private final MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica;
    private final MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica;
    private final MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarActividadGestionEstrategica(ServicioGuardarActividadGestionEstrategica servicioGuardarActividadGestionEstrategica, MapeadorAplicacionActividadGestionEstrategica mapeadorAplicacionActividadGestionEstrategica,
                                                                MapeadorAplicacionInformacionActividadGestionEstrategica mapeadorAplicacionInformacionActividadGestionEstrategica, MapeadorAplicacionDocumentoActividadGestionEstrategica mapeadorAplicacionDocumentoActividadGestionEstrategica, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarActividadGestionEstrategica = servicioGuardarActividadGestionEstrategica;
        this.mapeadorAplicacionActividadGestionEstrategica = mapeadorAplicacionActividadGestionEstrategica;
        this.mapeadorAplicacionInformacionActividadGestionEstrategica = mapeadorAplicacionInformacionActividadGestionEstrategica;
        this.mapeadorAplicacionDocumentoActividadGestionEstrategica = mapeadorAplicacionDocumentoActividadGestionEstrategica;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadGestionEstrategica dto){
        var actividad = this.mapeadorAplicacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestionEstrategica.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionEstrategica.ejecutarGuardar(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoActividadGestionEstrategica dto,Long idActividadEstrategica,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var actividad = this.mapeadorAplicacionActividadGestionEstrategica.mapeadorAplicacionDuplicar(dto,idActividadEstrategica,fechaInicial,fechaFinal);
        var informacionActividad = this.mapeadorAplicacionInformacionActividadGestionEstrategica.mapeadorAplicacionDuplicar(fechaInicial,fechaFinal);

        return new DtoRespuesta<>(this.servicioGuardarActividadGestionEstrategica.ejecutarGuardarDuplicado(actividad,informacionActividad));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoActividadGestionEstrategica dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoActividadGestionEstrategica.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarActividadGestionEstrategica.ejecutarGuardarDocumento(documento,codigo));
    }
}
