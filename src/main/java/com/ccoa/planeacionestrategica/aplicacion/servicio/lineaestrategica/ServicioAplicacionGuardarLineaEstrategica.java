package com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioGuardarLineaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarLineaEstrategica {

    private final ServicioGuardarLineaEstrategica servicioGuardarLineaEstrategica;

    public ServicioAplicacionGuardarLineaEstrategica(ServicioGuardarLineaEstrategica servicioGuardarLineaEstrategica) {
        this.servicioGuardarLineaEstrategica = servicioGuardarLineaEstrategica;
    }

    public DtoRespuesta<Long> ejecutar(DtoLineaEstrategica dto){
        //List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        LineaEstrategica lineaEstrategica = LineaEstrategica.of(dto.getNombre(), dto.getEntregable(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                dto.getIndicadorResultado(), dto.getIdPrograma(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioGuardarLineaEstrategica.ejecutarGuardar(lineaEstrategica));
    }
}
