package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.documento.MapeadorAplicacionDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionInformacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioModificarSprint;
import org.springframework.stereotype.Component;

@Component
public class  ServicioAplicacionModificarSprint {
    private final ServicioModificarSprint servicioModificarSprint;
    private final MapeadorAplicacionSprint mapeadorAplicacionSprint;
    private final MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint;
    private final MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint;

    public ServicioAplicacionModificarSprint(ServicioModificarSprint servicioModificarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint, MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint, MapeadorAplicacionDocumentoSprint mapeadorAplicacionDocumentoSprint) {
        this.servicioModificarSprint = servicioModificarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
        this.mapeadorAplicacionInformacionSprint = mapeadorAplicacionInformacionSprint;
        this.mapeadorAplicacionDocumentoSprint = mapeadorAplicacionDocumentoSprint;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoSprint dto, Long codigo){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        var informacionSprint = this.mapeadorAplicacionInformacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarSprint.ejecutarModificar(sprint,informacionSprint,codigo));
    }
    public DtoRespuesta<Long> modificarDocumento(DtoDocumentoSprint dto, Long codigo){
        var documento = this.mapeadorAplicacionDocumentoSprint.mapeadorAplicacionModificar(dto,codigo);
        return new DtoRespuesta<>(this.servicioModificarSprint.modificarDocumento(documento,codigo));
    }
}
