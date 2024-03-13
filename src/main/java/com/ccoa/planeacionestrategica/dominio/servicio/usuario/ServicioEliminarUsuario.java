package com.ccoa.planeacionestrategica.dominio.servicio.usuario;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarUsuario {
    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioUsuario.consultarPorId(id)== null) throw new ExcepcionValidadorObligatorio(NO_EXISTE_EL_USUARIO_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioUsuario.eliminar(id);
    }
}
