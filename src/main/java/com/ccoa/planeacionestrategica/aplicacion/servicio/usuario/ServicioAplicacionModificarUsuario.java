package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioModificarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public DtoRespuesta<Long> ejecutarModificar(DtoUsuario dto, Long codigo){

        List<Rol> roles = Arrays.asList(dto.getRoles().toArray(new Rol[0]));

        Usuario usuario = Usuario.of(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(), dto.getIdCargo(),
               roles);

        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificar(usuario,codigo));
    }
}
