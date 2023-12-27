package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.YA_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarUsuario {
    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarGuardar(Usuario usuario, Rol rol, InformacionUsuario informacionUsuario){

        if(this.repositorioUsuario.existe(usuario)) throw new ValorInvalidoExcepcion(YA_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.guardar(usuario,rol, informacionUsuario );
    }
}
