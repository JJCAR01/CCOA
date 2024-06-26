package com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionDetalleProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionInformacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.MapeadorAplicacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.mapeador.documento.MapeadorAplicacionDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.dominio.servicio.proyectoarea.ServicioGuardarProyectoArea;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarProyectoArea {
    private final ServicioGuardarProyectoArea servicioGuardarProyectoArea;
    private final MapeadorAplicacionProyectoArea mapeadorAplicacionProyectoArea;
    private final MapeadorAplicacionInformacionProyectoArea mapeadorAplicacionInformacionProyectoArea;
    private final MapeadorAplicacionDetalleProyectoArea mapeadorAplicacionDetalleProyectoArea;
    private final MapeadorAplicacionDocumentoProyectoArea mapeadorAplicacionDocumentoProyectoArea;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarProyectoArea(ServicioGuardarProyectoArea servicioGuardarProyectoArea, MapeadorAplicacionProyectoArea mapeadorAplicacionProyectoArea,
                                                 MapeadorAplicacionInformacionProyectoArea mapeadorAplicacionInformacionProyectoArea, MapeadorAplicacionDetalleProyectoArea mapeadorAplicacionDetalleProyectoArea, MapeadorAplicacionDocumentoProyectoArea mapeadorAplicacionDocumentoProyectoArea, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarProyectoArea = servicioGuardarProyectoArea;
        this.mapeadorAplicacionProyectoArea = mapeadorAplicacionProyectoArea;
        this.mapeadorAplicacionInformacionProyectoArea = mapeadorAplicacionInformacionProyectoArea;
        this.mapeadorAplicacionDetalleProyectoArea = mapeadorAplicacionDetalleProyectoArea;
        this.mapeadorAplicacionDocumentoProyectoArea = mapeadorAplicacionDocumentoProyectoArea;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoProyectoArea dto){
        var proyectoArea = this.mapeadorAplicacionProyectoArea.mapeadorAplicacion(dto);
        var informacionProyectoArea = this.mapeadorAplicacionInformacionProyectoArea.mapeadorAplicacion(dto);
        var detalleProyectoArea = this.mapeadorAplicacionDetalleProyectoArea.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarProyectoArea.ejecutarGuardar(proyectoArea,informacionProyectoArea,detalleProyectoArea));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoProyectoArea dto,Long idPat,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var proyectoArea = this.mapeadorAplicacionProyectoArea.mapeadorAplicacionDuplicar(dto,idPat);
        var informacionProyectoArea = this.mapeadorAplicacionInformacionProyectoArea.mapeadorAplicacionDuplicar(dto,fechaInicial,fechaFinal);
        var detalleProyectoArea = this.mapeadorAplicacionDetalleProyectoArea.mapeadorAplicacionDuplicar(fechaInicial,fechaFinal);

        return new DtoRespuesta<>(this.servicioGuardarProyectoArea.ejecutarGuardarDuplicado(proyectoArea,informacionProyectoArea,detalleProyectoArea));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoProyectoArea dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoProyectoArea.mapeadorAplicacionCrear(dto,codigo);
        return new DtoRespuesta<>(this.servicioGuardarProyectoArea.ejecutarGuardarDocumento(documento,codigo));
    }
}
