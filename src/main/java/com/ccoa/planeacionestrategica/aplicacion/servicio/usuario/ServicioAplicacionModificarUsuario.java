package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.servicio.cargo.ServicioModificarCargo;
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

        Usuario usuario = Usuario.of(dto.getNombreUsuario(),dto.getNombre(), dto.getApellidos(), dto.getPassword(), dto.getCorreo(),
                dto.getIdRol(), dto.getIdCargo());

        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutarModificar(usuario,codigo));
    }
}
