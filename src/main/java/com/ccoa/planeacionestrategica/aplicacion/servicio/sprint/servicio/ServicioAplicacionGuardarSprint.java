package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoRutaArchivo;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionInformacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioGuardarSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarSprint {
    private final ServicioGuardarSprint servicioGuardarSprint;
    private final MapeadorAplicacionSprint mapeadorAplicacionSprint;
    private final MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint;
    private final MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint;

    public ServicioAplicacionGuardarSprint(ServicioGuardarSprint servicioGuardarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint,
                                           MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint, MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint) {
        this.servicioGuardarSprint = servicioGuardarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
        this.mapeadorAplicacionInformacionSprint = mapeadorAplicacionInformacionSprint;
        this.mapeadorAplicacionDocumentoSprint = mapeadorAplicacionDocumentoSprint;
    }

    public DtoRespuesta<Long> ejecutar(DtoSprint dto){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        var informacionSprint = this.mapeadorAplicacionInformacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardar(sprint,informacionSprint));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoRutaArchivo dto, Long codigo){
        var docSprint = this.mapeadorAplicacionDocumentoSprint.mapeadorAplicacionCrear(dto,codigo);

        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardarDocumento(docSprint,codigo));
    }
}
