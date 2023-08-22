package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPrograma;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioModificarLineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioModificarPrograma;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarLineaEstrategica {

    private final ServicioModificarLineaEstrategica servicioModificarLineaEstrategica;

    public ServicioAplicacionModificarLineaEstrategica(ServicioModificarLineaEstrategica servicioModificarLineaEstrategica) {
        this.servicioModificarLineaEstrategica = servicioModificarLineaEstrategica;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoLineaEstrategica dto, Long codigo) {
        //List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        LineaEstrategica lineaEstrategica = LineaEstrategica.of(dto.getNombre(), dto.getEntregable(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                    dto.getIndicadorResultado(), dto.getIdPrograma(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioModificarLineaEstrategica.ejecutarModificar(lineaEstrategica,codigo));
    }
}
