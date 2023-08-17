package com.ccoa.planeacionestrategica.aplicacion.servicio.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.pat.ServicioModificarPat;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarPat {

    private final ServicioModificarPat servicioModificarPat;

    public ServicioAplicacionModificarPat(ServicioModificarPat servicioModificarPat) {
        this.servicioModificarPat = servicioModificarPat;
    }

    /*public DtoRespuesta<Long> ejecutarModificar(DtoPat dto, Long codigo){
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));

        Pat pat  = Pat.of(dto.getNombre(),dto.getFechaInicio(),dto.getFechaFinal(),dto.getFechaRegistro(),
                Usuario.of(dto.getDtoUsuario().getNombreUsuario(),dto.getDtoUsuario().getNombre(),dto.getDtoUsuario().getApellidos(),
                        dto.getDtoUsuario().getPassword(),dto.getDtoUsuario().getCorreo(),roles,
                        Cargo.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre(),
                                Area.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))));

        return new DtoRespuesta<>(this.servicioModificarPat.ejecutarModificar(pat,codigo));
    }

     */
}
