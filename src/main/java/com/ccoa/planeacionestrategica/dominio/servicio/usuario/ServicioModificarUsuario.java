package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarUsuario {
    private static final String MENSAJE_NO_EXISTE = "No existe el Usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioModificarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarModificar(Usuario usuario, Long codigo){

        if(this.repositorioUsuario.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificar(usuario,codigo);
    }
}
