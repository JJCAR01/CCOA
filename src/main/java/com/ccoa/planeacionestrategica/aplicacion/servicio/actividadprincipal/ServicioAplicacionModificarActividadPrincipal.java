package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioModificarActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioModificarLineaEstrategica;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionModificarActividadPrincipal {
    private final ServicioModificarActividadPrincipal servicioModificarActividadPrincipal;

    public ServicioAplicacionModificarActividadPrincipal(ServicioModificarActividadPrincipal servicioModificarActividadPrincipal) {
        this.servicioModificarActividadPrincipal = servicioModificarActividadPrincipal;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadPrincipal dto, Long codigo) {
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));


        ActividadPrincipal actividadPrincipal = ActividadPrincipal.of(dto.getNombre(),
                dto.getTipoActividad(), dto.getEntregable(), dto.getPresupuesto(), dto.getFechaInicio(),dto.getFechaFinal(),dto.getFechaRegistro(),
                LineaEstrategica.of(dto.getDtoLineaEstrategica().getNombre(),dto.getDtoLineaEstrategica().getEntregable(),dto.getDtoLineaEstrategica().getFechaInicio(),
                        dto.getDtoLineaEstrategica().getFechaFinal(),dto.getDtoLineaEstrategica().getFechaRegistro(),dto.getDtoLineaEstrategica().getIndicadorResultado(),
                        Programa.of(dto.getDtoLineaEstrategica().getDtoPrograma().getNombre(),dto.getDtoLineaEstrategica().getDtoPrograma().getCodigo(),dto.getDtoLineaEstrategica().getDtoPrograma().getVersion(),
                                dto.getDtoLineaEstrategica().getDtoPrograma().getFechaInicio(),
                                dto.getDtoLineaEstrategica().getDtoPrograma().getFechaFinal(),dto.getDtoLineaEstrategica().getDtoPrograma().getFechaRegistro(),dto.getDtoLineaEstrategica().getDtoPrograma().getPresupuestoGasto(),
                                dto.getDtoLineaEstrategica().getDtoPrograma().getPresupuestoGasto(),
                                ImperativoEstrategico.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getNombre(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getFechaInicio(),
                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getFechaFinal(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getFechaRegistro(),
                                        Pat.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getNombre(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaInicio(),
                                                dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaFinal(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getFechaRegistro(),
                                                Usuario.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombreUsuario(),
                                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getNombre(),
                                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getApellidos(),
                                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getPassword(),
                                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getCorreo(),roles,
                                                        Cargo.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getNombre(),
                                                                Area.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoPat().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                                        Usuario.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getNombreUsuario(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getNombre(),
                                                dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getApellidos(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getPassword(),
                                                dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getCorreo(),roles,
                                                Cargo.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getNombre(),
                                                        Area.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoImperativoEstrategico().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                                Usuario.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getNombreUsuario(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getNombre(),
                                        dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getApellidos(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getPassword(),dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getCorreo(),roles,
                                        Cargo.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getDtoCargo().getNombre(),
                                                Area.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))),
                                Area.of(dto.getDtoLineaEstrategica().getDtoPrograma().getDtoArea().getNombre())),
                        Usuario.of(dto.getDtoLineaEstrategica().getDtoUsuario().getNombreUsuario(),dto.getDtoLineaEstrategica().getDtoUsuario().getNombre(),dto.getDtoLineaEstrategica().getDtoUsuario().getApellidos(),dto.getDtoLineaEstrategica().getDtoUsuario().getPassword(),
                                dto.getDtoLineaEstrategica().getDtoUsuario().getCorreo(),roles,Cargo.of(dto.getDtoLineaEstrategica().getDtoUsuario().getDtoCargo().getNombre(),
                                        Area.of(dto.getDtoLineaEstrategica().getDtoUsuario().getDtoCargo().getDtoArea().getNombre())))),
                Usuario.of(dto.getDtoUsuario().getNombreUsuario(),dto.getDtoUsuario().getNombre(),dto.getDtoUsuario().getApellidos(),dto.getDtoUsuario().getPassword(),
                        dto.getDtoUsuario().getCorreo(),roles,Cargo.of(dto.getDtoUsuario().getDtoCargo().getNombre(),
                                Area.of(dto.getDtoUsuario().getDtoCargo().getDtoArea().getNombre()))),
                TipoGI.of(dto.getDtoTipoGI().getCantidad(),dto.getDtoTipoGI().getValorUnitario(),dto.getDtoTipoGI().getValorTotal(),dto.getDtoTipoGI().getObservacion()
                        ,dto.getDtoTipoGI().getClasificacion()));

        return new DtoRespuesta<>(this.servicioModificarActividadPrincipal.ejecutarModificar(actividadPrincipal,codigo));

    }
}
