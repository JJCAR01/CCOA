package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico.ServicioModificarImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarImperativoEstrategico {

    private final ServicioModificarImperativoEstrategico servicioModificarImperativoEstrategico;

    public ServicioAplicacionModificarImperativoEstrategico(ServicioModificarImperativoEstrategico servicioModificarImperativoEstrategico) {
        this.servicioModificarImperativoEstrategico = servicioModificarImperativoEstrategico;
    }

    /*public DtoRespuesta<Long> ejecutarModificar(DtoImperativoEstrategico dto, Long codigo){
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        ImperativoEstrategico imperativoEstrategico  = ImperativoEstrategico.of(dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),
                dto.getFechaRegistro(),Pat.of(dto.getDtoPat().getNombre(),
                        dto.getDtoPat().getFechaInicio(),
                        dto.getDtoPat().getFechaFinal(),
                        dto.getDtoPat().getFechaRegistro(),
                        Usuario.of(dto.getDtoPat().getDtoUsuario().getNombreUsuario(),dto.getDtoPat().getDtoUsuario().getNombre(),
                                dto.getDtoPat().getDtoUsuario().getApellidos(),dto.getDtoPat().getDtoUsuario().getPassword(),
                                dto.getDtoPat().getDtoUsuario().getCorreo(),roles,Cargo.of(dto.getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre(),
                                        Area.of(dto.getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),Usuario.of(dto.getDtoUsuario().getNombreUsuario(),dto.getDtoUsuario().getNombre(),dto.getDtoUsuario().getApellidos(),
                                dto.getDtoUsuario().getPassword(),dto.getDtoUsuario().getCorreo(),roles,
                                Cargo.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre(),
                                        Area.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))));

        return new DtoRespuesta<>(this.servicioModificarImperativoEstrategico.ejecutarModificar(imperativoEstrategico,codigo));
    }

     */
}
