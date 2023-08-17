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

    /*public DtoRespuesta<Long> ejecutarModificar(DtoPrograma dto, Long codigo){
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        Programa programa = Programa.of(dto.getNombre(), dto.getCodigo(), dto.getVersion(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                dto.getPresupuestoIngreso(), dto.getPresupuestoGasto(),
                ImperativoEstrategico.of(dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(), dto.getFechaRegistro(),
                        Pat.of(dto.getDtoImperativoEstrategico().getDtoPat().getNombre(), dto.getDtoImperativoEstrategico().getDtoPat().getFechaInicio(),
                                dto.getDtoImperativoEstrategico().getDtoPat().getFechaFinal(), dto.getDtoImperativoEstrategico().getDtoPat().getFechaRegistro(),
                                Usuario.of(dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombreUsuario(),dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombre(),
                                        dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getApellidos(),dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getPassword(),
                                        dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getCorreo(),roles,
                                        Cargo.of(dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre(),
                                                Area.of(dto.getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                        Usuario.of(dto.getDtoImperativoEstrategico().getDtoUsuario().getNombreUsuario(),dto.getDtoImperativoEstrategico().getDtoUsuario().getNombre(),
                                dto.getDtoImperativoEstrategico().getDtoUsuario().getApellidos(),dto.getDtoImperativoEstrategico().getDtoUsuario().getPassword(),
                                dto.getDtoImperativoEstrategico().getDtoUsuario().getCorreo(),roles,
                                Cargo.of(dto.getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getNombre(),
                                        Area.of(dto.getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                Usuario.of(dto.getDtoUsuario().getNombreUsuario(),dto.getDtoUsuario().getNombre(),dto.getDtoUsuario().getApellidos(),
                        dto.getDtoUsuario().getPassword(),dto.getDtoUsuario().getCorreo(),roles,
                        Cargo.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre(),
                                Area.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))),
                Area.of(dto.getDtoArea().getNombre()));

        return new DtoRespuesta<>(this.servicioModificarPrograma.ejecutarModificar(programa,codigo));
    }

     */
}
