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
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));


        LineaEstrategica lineaEstrategica = LineaEstrategica.of(dto.getNombre(), dto.getEntregable(), dto.getFechaInicio(), dto.getFechaFinal(), dto.getFechaRegistro(),
                dto.getIndicadorResultado(),
                Programa.of(dto.getDtoPrograma().getNombre(), dto.getDtoPrograma().getCodigo(), dto.getDtoPrograma().getVersion(), dto.getDtoPrograma().getFechaInicio(),
                        dto.getDtoPrograma().getFechaFinal(), dto.getDtoPrograma().getFechaRegistro(), dto.getDtoPrograma().getPresupuestoGasto(), dto.getDtoPrograma().getPresupuestoGasto(),
                        ImperativoEstrategico.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getNombre(), dto.getDtoPrograma().getDtoImperativoEstrategico().getFechaInicio(),
                                dto.getDtoPrograma().getDtoImperativoEstrategico().getFechaFinal(), dto.getDtoPrograma().getDtoImperativoEstrategico().getFechaRegistro(),
                                Pat.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getNombre(), dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaInicio(),
                                        dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaFinal(), dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaRegistro(),
                                        Usuario.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombreUsuario(),
                                                dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombre(),
                                                dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getApellidos(),
                                                dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getPassword(),
                                                dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getCorreo(), roles,
                                                Cargo.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getNombre(),
                                                        Area.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                                Usuario.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getNombreUsuario(), dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getNombre(),
                                        dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getApellidos(), dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getPassword(),
                                        dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getCorreo(), roles,
                                        Cargo.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getNombre(),
                                                Area.of(dto.getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                        Usuario.of(dto.getDtoPrograma().getDtoUsuario().getNombreUsuario(), dto.getDtoPrograma().getDtoUsuario().getNombre(),
                                dto.getDtoPrograma().getDtoUsuario().getApellidos(), dto.getDtoPrograma().getDtoUsuario().getPassword(), dto.getDtoPrograma().getDtoUsuario().getCorreo(), roles,
                                Cargo.of(dto.getDtoPrograma().getDtoUsuario().getDtoCargo().getNombre(),
                                        Area.of(dto.getDtoPrograma().getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))),
                        Area.of(dto.getDtoPrograma().getDtoArea().getNombre())),
                Usuario.of(dto.getDtoUsuario().getNombreUsuario(), dto.getDtoUsuario().getNombre(), dto.getDtoUsuario().getApellidos(), dto.getDtoUsuario().getPassword(),
                        dto.getDtoUsuario().getCorreo(), roles, Cargo.of(dto.getDtoUsuario().getDtoCargo().getNombre(),
                                Area.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))));

        return new DtoRespuesta<>(this.servicioModificarLineaEstrategica.ejecutarModificar(lineaEstrategica,codigo));

    }
}
