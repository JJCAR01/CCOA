package com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.direccion.ServicioEliminarDireccion;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarDireccion {
    private final ServicioEliminarDireccion servicioEliminarDireccion;

    public ServicioAplicacionEliminarDireccion(ServicioEliminarDireccion servicioEliminarDireccion) {
        this.servicioEliminarDireccion = servicioEliminarDireccion;
    }

    @Secured("ROLE_ADMIN")
    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarDireccion.ejecutarEliminar(codigo));
    }
}
