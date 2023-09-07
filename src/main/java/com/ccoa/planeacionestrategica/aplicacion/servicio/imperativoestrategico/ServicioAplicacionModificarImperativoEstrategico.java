package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioModificarImperativoEstrategico;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarImperativoEstrategico {

    private final ServicioModificarImperativoEstrategico servicioModificarImperativoEstrategico;

    public ServicioAplicacionModificarImperativoEstrategico(ServicioModificarImperativoEstrategico servicioModificarImperativoEstrategico) {
        this.servicioModificarImperativoEstrategico = servicioModificarImperativoEstrategico;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoImperativoEstrategico dto, Long codigo){

        ImperativoEstrategico imperativoEstrategico = ImperativoEstrategico.of(dto.getIdImperativoEstrategico(), dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),
                dto.getFechaRegistro(), dto.getPorcentajeReal(), dto.getPorcentajeEsperado(), dto.getCumplimiento(),
                dto.getIdPat(), dto.getIdUsuario());
        return new DtoRespuesta<>(this.servicioModificarImperativoEstrategico.ejecutarModificar(imperativoEstrategico,codigo));
    }
}
