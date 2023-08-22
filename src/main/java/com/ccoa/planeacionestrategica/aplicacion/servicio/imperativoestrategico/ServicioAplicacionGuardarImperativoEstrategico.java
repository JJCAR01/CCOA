package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioGuardarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioGuardarPat;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarImperativoEstrategico {

    private final ServicioGuardarImperativoEstrategico servicioGuardarImperativoEstrategico;

    public ServicioAplicacionGuardarImperativoEstrategico(ServicioGuardarImperativoEstrategico servicioGuardarImperativoEstrategico) {
        this.servicioGuardarImperativoEstrategico = servicioGuardarImperativoEstrategico;
    }

    public DtoRespuesta<Long> ejecutar(DtoImperativoEstrategico dto){
        //List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        ImperativoEstrategico imperativoEstrategico = ImperativoEstrategico.of(dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),
                dto.getFechaRegistro(), dto.getIdPat(), dto.getIdUsuario());

        return new DtoRespuesta<>(this.servicioGuardarImperativoEstrategico.ejecutarGuardar(imperativoEstrategico));
    }
}
