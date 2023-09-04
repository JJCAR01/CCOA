package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarUsuario {

    private static final String MENSAJE_YA_EXISTE = "No existe el Usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioUsuario.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioUsuario.eliminar(id);
    }
}
