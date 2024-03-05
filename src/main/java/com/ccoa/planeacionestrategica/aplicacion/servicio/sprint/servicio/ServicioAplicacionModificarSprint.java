package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

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

    public ServicioAplicacionModificarSprint(ServicioModificarSprint servicioModificarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint, MapeadorAplicacionInformacionSprint mapeadorAplicacionInformacionSprint) {
        this.servicioModificarSprint = servicioModificarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
        this.mapeadorAplicacionInformacionSprint = mapeadorAplicacionInformacionSprint;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoSprint dto, Long codigo){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        var informacionSprint = this.mapeadorAplicacionInformacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarSprint.ejecutarModificar(sprint,informacionSprint,codigo));
    }
}
