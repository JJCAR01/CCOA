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

    /*public DtoRespuesta<Long> ejecutarModificar(DtoActividadPrincipal dto, Long codigo) {
        List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));


        return new DtoRespuesta<>(this.servicioModificarActividadPrincipal.ejecutarModificar(actividadPrincipal,codigo));

    }

     */
}
