package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarUsuario {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public DtoRespuesta<Long> ejecutarEliminar(Long codigo){
        return new DtoRespuesta<>(this.servicioEliminarUsuario.ejecutarEliminar(codigo));
    }
}
