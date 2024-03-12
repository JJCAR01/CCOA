package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
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

    public Long ejecutarModificar(Usuario usuario, Rol rol , InformacionUsuario informacionUsuario, Long codigo){

        if(this.repositorioUsuario.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificar(usuario,rol,informacionUsuario , codigo);
    }
    public Long ejecutarAgregarPass(Usuario usuario, InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificarAgregarPass(usuario,informacionUsuario , codigo);
    }
    public Long ejecutarModificarDirecciones(InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorIdParaModificar(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificarDireciones(informacionUsuario , codigo);
    }
    public Long ejecutarEliminarDirecciones(InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorIdParaModificar(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificarDirecionesParaEliminar(informacionUsuario , codigo);
    }
    public Long ejecutarModificarPats(InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorIdParaModificar(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificarPats(informacionUsuario , codigo);
    }
    public Long ejecutarEliminarPats(InformacionUsuario informacionUsuario,Long codigo){

        if(this.repositorioUsuario.consultarPorIdParaModificar(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.modificarPatParaEliminar(informacionUsuario , codigo);
    }
}
