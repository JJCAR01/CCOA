package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarUsuario {
    private final RepositorioUsuario repositorioUsuario;

    public ServicioModificarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarModificar(Usuario usuario, InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificar(usuario,informacionUsuario , codigo);
    }
}
