package com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.mapeador.MapeadorAplicacionSprint;
import com.ccoa.planeacionestrategica.dominio.servicio.sprint.ServicioModificarSprint;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarSprint {
    private final ServicioModificarSprint servicioModificarSprint;
    private final MapeadorAplicacionSprint mapeadorAplicacionSprint;

    public ServicioAplicacionModificarSprint(ServicioModificarSprint servicioModificarSprint, MapeadorAplicacionSprint mapeadorAplicacionSprint) {
        this.servicioModificarSprint = servicioModificarSprint;
        this.mapeadorAplicacionSprint = mapeadorAplicacionSprint;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoSprint dto, Long codigo){
        var sprint = this.mapeadorAplicacionSprint.mapeadorAplicacion(dto);
        return new DtoRespuesta<>(this.servicioModificarSprint.ejecutarModificar(sprint,codigo));
    }
}
