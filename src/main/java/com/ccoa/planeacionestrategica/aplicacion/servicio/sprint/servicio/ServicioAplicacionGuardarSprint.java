package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
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
        var docSprint = this.mapeadorAplicacionDocumentoSprint.mapeadorAplicacion(dto);

        return new DtoRespuesta<>(this.servicioGuardarSprint.ejecutarGuardar(sprint,docSprint));
    }
}
