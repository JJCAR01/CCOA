package com.ccoa.planeacionestrategica.aplicacion.servicio.programa;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPrograma;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioModificarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioModificarPrograma;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarPrograma {

    private final ServicioModificarPrograma servicioModificarPrograma;

    public ServicioAplicacionModificarPrograma(ServicioModificarPrograma servicioModificarPrograma) {
        this.servicioModificarPrograma = servicioModificarPrograma;
    }
    public DtoRespuesta<Long> ejecutarModificar(DtoPrograma dto, Long codigo){
        //List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        Programa programa = Programa.of(dto.getNombre(), dto.getCodigo(), dto.getVersion(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                dto.getPresupuestoIngreso(), dto.getPresupuestoGasto(), dto.getIdImperativoEstrategico(),
                dto.getIdUsuario(), dto.getIdArea());

        return new DtoRespuesta<>(this.servicioModificarPrograma.ejecutarModificar(programa,codigo));
    }
}
