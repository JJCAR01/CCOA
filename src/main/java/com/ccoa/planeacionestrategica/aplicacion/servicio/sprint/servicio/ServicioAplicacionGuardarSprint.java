package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.documento.MapeadorAplicacionDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionInformacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioGuardarSprint;
import com.ccoa.planeacionestrategica.dominio.transversal.servicio.ServicioCambiarFecha;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarSprint {
    private final ServicioGuardarSprint servicioGuardarSprint;
    private final MapeadorAplicacionSprint mapeadorAplicacionSprint;
    private final MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint;
    private final MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint;
    private final ServicioCambiarFecha servicioCambiarFecha;

    public ServicioAplicacionGuardarSprint(ServicioGuardarSprint servicioGuardarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint,
                                           MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint, MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint, ServicioCambiarFecha servicioCambiarFecha) {
        this.servicioGuardarSprint = servicioGuardarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
        this.mapeadorAplicacionInformacionSprint = mapeadorAplicacionInformacionSprint;
        this.mapeadorAplicacionDocumentoSprint = mapeadorAplicacionDocumentoSprint;
        this.servicioCambiarFecha = servicioCambiarFecha;
    }

    public DtoRespuesta<Long> ejecutar(DtoSprint dto){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        var informacionSprint = this.mapeadorAplicacionInformacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardar(sprint,informacionSprint));
    }
    public DtoRespuesta<Long> guardarDuplicado(DtoSprint dto, Long idProyecto,Integer fechaAnual){
        var fechaInicial = servicioCambiarFecha.calcular(dto.getFechaInicial(),fechaAnual);
        var fechaFinal = servicioCambiarFecha.calcular(dto.getFechaFinal(),fechaAnual);

        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacionDuplicar(dto,idProyecto,fechaInicial,fechaFinal);
        var informacionSprint = this.mapeadorAplicacionInformacionSprint.mapeadorAplicacionDuplicar(fechaInicial,fechaFinal);

        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardar(sprint,informacionSprint));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoDocumentoSprint dto, Long codigo){
        var docSprint = this.mapeadorAplicacionDocumentoSprint.mapeadorAplicacionCrear(dto,codigo);

        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardarDocumento(docSprint,codigo));
    }
}
