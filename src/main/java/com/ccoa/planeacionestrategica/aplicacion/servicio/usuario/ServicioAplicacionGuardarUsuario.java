package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.servicio.usuario.ServicioGuardarUsuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;


    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto){

        //List<Rol> roles = Arrays.asList(Rol.of("A"),Rol.of("EGRESADO"));

        Usuario usuario = Usuario.of(dto.getIdCargo(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), dto.getRoles());
        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutarGuardar(usuario));
    }

}
