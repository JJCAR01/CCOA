package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<DtoUsuarioResumen> ejecutar(){return this.repositorioUsuario.listar();}

    public DtoUsuarioResumen consultarById(Long id){return this.repositorioUsuario.consultarPorId(id);}
    public Long consultarByCorreoParaIdUsuario(String correo){return this.repositorioUsuario.obtenerIdUsuarioDelUsuario(correo);}
    public List<String> consultarByCorreoParaDirecciones(String correo){return this.repositorioUsuario.obtenerDireccionesDelUsuario(correo);}
    public List<String> consultarByCorreoParaPats(String correo){return this.repositorioUsuario.obtenerPatsDelUsuario(correo);}
}
