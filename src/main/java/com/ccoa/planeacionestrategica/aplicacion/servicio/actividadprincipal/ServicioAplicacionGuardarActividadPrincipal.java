package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.*;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioGuardarActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioGuardarLineaEstrategica;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarActividadPrincipal {

    private final ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal;

    public ServicioAplicacionGuardarActividadPrincipal(ServicioGuardarActividadPrincipal servicioGuardarActividadPrincipal) {
        this.servicioGuardarActividadPrincipal = servicioGuardarActividadPrincipal;
    }

    public DtoRespuesta<Long> ejecutar(DtoActividadPrincipal dto){

        ActividadPrincipal actividadPrincipal = ActividadPrincipal.of(dto.getNombre(), dto.getTipoActividad(), dto.getEntregable(),dto.getPresupuesto(),
                dto.getFechaInicio(),dto.getFechaFinal(),dto.getFechaRegistro(), dto.getIdLineaEstrategica(), dto.getIdUsuario(),dto.getIdTipoGI());

        return new DtoRespuesta<>(this.servicioGuardarActividadPrincipal.ejecutarGuardar(actividadPrincipal));
    }
}
