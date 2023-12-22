package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
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

    public String consultarByCorreoParaDireccion(String correo){return this.repositorioUsuario.obtenerDireccionDelUsuario(correo);}
    public String consultarByCorreoParaProceso(String correo){return this.repositorioUsuario.obtenerProcesoDelUsuario(correo);}
}
