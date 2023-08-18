package com.ccoa.planeacionestrategica.aplicacion.servicio.login;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.encriptar.ServicioAplicacionEncriptarPassword;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicioAplicacionLogin {

    private final ServicioAplicacionEncriptarPassword servicioAplicacionEncriptarPassword;
    //private final ServiceGeneratorToken serviceGeneratorToken;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionLogin(ServicioAplicacionEncriptarPassword servicioAplicacionEncriptarPassword, RepositorioUsuario repositorioUsuario) {
        this.servicioAplicacionEncriptarPassword = servicioAplicacionEncriptarPassword;
        this.repositorioUsuario = repositorioUsuario;
    }

    public String ejecutar(DtoLogin dto){
        String passwordEncriptada = this.servicioAplicacionEncriptarPassword.ejecutar(dto.getPassword());
        Usuario usuario = this.repositorioUsuario.consultar(dto.getNombreUsuario(),passwordEncriptada);
        if(usuario == null){
            throw  new IllegalStateException("Email o contraseña incorrecta");
        }

        //List<String> roles = user.getRols().stream().map(Rol::getRol).toList();
        //Falta implementar token
        //return this.serviceGeneratorToken.execute(dto.getEmail(), roles)
        return "Hecho";
    }

}
