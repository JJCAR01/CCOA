package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadprincipal.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioModificarActividadPrincipal;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarActividadPrincipal {
    private final ServicioModificarActividadPrincipal servicioModificarActividadPrincipal;

    public ServicioAplicacionModificarActividadPrincipal(ServicioModificarActividadPrincipal servicioModificarActividadPrincipal) {
        this.servicioModificarActividadPrincipal = servicioModificarActividadPrincipal;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoActividadPrincipal dto, Long codigo) {

        ActividadPrincipal actividadPrincipal = ActividadPrincipal.of(dto.getIdActividadPrincipal(),dto.getNombre(), dto.getTipoActividad(), dto.getEntregable(),dto.getPresupuesto(),
                dto.getFechaInicio(),dto.getFechaFinal(),dto.getFechaRegistro());


        return new DtoRespuesta<>(this.servicioModificarActividadPrincipal.ejecutarModificar(actividadPrincipal,codigo));

    }


}
