package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal.ServicioEliminarActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica.ServicioEliminarLineaEstrategica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarActividadPrincipal {

    private final ServicioEliminarActividadPrincipal servicioEliminarActividadPrincipal;

    public ServicioAplicacionEliminarActividadPrincipal(ServicioEliminarActividadPrincipal servicioEliminarActividadPrincipal) {
        this.servicioEliminarActividadPrincipal = servicioEliminarActividadPrincipal;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarActividadPrincipal.ejecutarEliminar(codigo));
    }
}
