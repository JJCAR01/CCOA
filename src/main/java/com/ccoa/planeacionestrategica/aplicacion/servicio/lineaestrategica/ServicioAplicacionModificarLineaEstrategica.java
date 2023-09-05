package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioModificarLineaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarLineaEstrategica {

    private final ServicioModificarLineaEstrategica servicioModificarLineaEstrategica;

    public ServicioAplicacionModificarLineaEstrategica(ServicioModificarLineaEstrategica servicioModificarLineaEstrategica) {
        this.servicioModificarLineaEstrategica = servicioModificarLineaEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoLineaEstrategica dto, Long codigo) {

        LineaEstrategica lineaEstrategica = LineaEstrategica.of(dto.getNombre(), dto.getEntregable(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                    dto.getIndicadorResultado(), dto.getIdPrograma(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioModificarLineaEstrategica.ejecutarModificar(lineaEstrategica,codigo));
    }
}
