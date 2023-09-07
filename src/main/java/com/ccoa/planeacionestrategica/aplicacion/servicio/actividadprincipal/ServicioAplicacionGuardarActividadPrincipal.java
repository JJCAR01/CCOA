package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadprincipal.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DetalleActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioGuardarActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.transversal.formateador.FormateadorHora;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarActividadPrincipal {

    private final ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal;

    public ServicioAplicacionGuardarActividadPrincipal(ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal) {
        this.servicioGuardarActividadPrincipal = servicioGuardarActividadPrincipal;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadPrincipal dto){

        ActividadPrincipal actividadPrincipal = ActividadPrincipal.of(dto.getIdActividadPrincipal(), dto.getNombre(), dto.getTipoActividad(), dto.getEntregable(),dto.getPresupuesto(),
                dto.getFechaInicio(),dto.getFechaFinal(),dto.getFechaRegistro());

        DetalleActividadPrincipal detalleActividadPrincipal = DetalleActividadPrincipal.of(dto.getIdLineaEstrategica(), dto.getIdUsuario(),
                dto.getIdTipoGI());

        return new DtoRespuesta<>(this.servicioGuardarActividadPrincipal.ejecutarGuardar(actividadPrincipal,detalleActividadPrincipal));
    }
}
