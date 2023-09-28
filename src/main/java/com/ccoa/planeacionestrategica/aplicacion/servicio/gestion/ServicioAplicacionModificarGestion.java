package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.servicio.gestion.ServicioModificarGestion;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarGestion {

    private final ServicioModificarGestion servicioModificarGestion;

    public ServicioAplicacionModificarGestion(ServicioModificarGestion servicioModificarGestion) {
        this.servicioModificarGestion = servicioModificarGestion;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoGestion dto, Long codigo){

        Gestion gestion= Gestion.of(dto.getIdGestion(), dto.getNombre(),dto.getIdPat());

        return new DtoRespuesta<>(this.servicioModificarGestion.ejecutarModificar(gestion,codigo));
    }
}
