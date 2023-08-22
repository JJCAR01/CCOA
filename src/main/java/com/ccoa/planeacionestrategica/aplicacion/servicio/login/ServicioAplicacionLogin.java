package com.ccoa.planeacionestrategica.aplicacion.servicio.login;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;

import com.ccoa.planeacionestrategica.dominio.servicio.ServicioCifrarTexto;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioGenerarToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicioAplicacionLogin {

    private final ServicioGenerarToken servicioGenerarToken;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionLogin(ServicioGenerarToken servicioGenerarToken,ServicioCifrarTexto servicioCifrarTexto,
                                   RepositorioUsuario repositorioUsuario) {
        this.servicioGenerarToken = servicioGenerarToken;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoRespuesta<String> ejecutar(DtoLogin dto) {

        String claveCifrada = this.servicioCifrarTexto.ejecutar(dto.getPassword());
        Usuario usuario = this.repositorioUsuario.consultar(dto.getNombreUsuario(), claveCifrada);

        if(usuario == null) {
            throw new IllegalStateException("Usuario o clave incorrecta");
        }

        //List<String> roles = usuario.getRoles().stream().map(Rol::getRol).toList();

        return new DtoRespuesta<>(this.servicioGenerarToken.ejecutar(dto.getNombreUsuario()));

    }

}
