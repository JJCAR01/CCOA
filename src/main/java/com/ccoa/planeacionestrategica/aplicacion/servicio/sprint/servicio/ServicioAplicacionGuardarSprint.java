package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoRutaArchivo;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioGuardarSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarSprint {
    private final ServicioGuardarSprint servicioGuardarSprint;
    private final MapeadorAplicacionSprint mapeadorAplicacionSprint;
    private final MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint;

    public ServicioAplicacionGuardarSprint(ServicioGuardarSprint servicioGuardarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint,
                                           MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint) {
        this.servicioGuardarSprint = servicioGuardarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
        this.mapeadorAplicacionDocumentoSprint = mapeadorAplicacionDocumentoSprint;
    }

    public DtoRespuesta<Long> ejecutar(DtoSprint dto){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardar(sprint));
    }
    public DtoRespuesta<Long> guardarRutaArchivo(DtoRutaArchivo dto, Long codigo){
        var docSprint = this.mapeadorAplicacionDocumentoSprint.mapeadorAplicacionCrear(dto,codigo);

        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardarDocumento(docSprint,codigo));
    }
}
