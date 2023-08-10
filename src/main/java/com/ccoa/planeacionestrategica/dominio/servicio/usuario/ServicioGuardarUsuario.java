package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuario {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarGuardar(Usuario usuario){

        if(this.repositorioUsuario.existe(usuario)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioUsuario.guardar(usuario);
    }
}
