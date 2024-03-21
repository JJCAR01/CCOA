package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.*;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividadGestionEstrategica {
    private final RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica;

    public ServicioEliminarActividadGestionEstrategica(RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica) {
        this.repositorioActividadGestionEstrategica = repositorioActividadGestionEstrategica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividadGestionEstrategica.consultarPorId(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionEstrategica.eliminar(id);
    }
    public Long ejecutarEliminarPorActEstrategica(Long id){

        if(this.repositorioActividadGestionEstrategica.consultarPorIdActividadEstrategicaAEliminar(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionEstrategica.eliminarPorActividadEstrategica(id);
    }
    public Long eliminarDocumento(Long id){
        if(this.repositorioActividadGestionEstrategica.consultarPorId(id)== null) throw new ExcepcionValidadorInvalido(NO_EXISTE_UN_DOCUMENTO_RELACIONADO_CON_LA_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA,MENSAJE_DEFECTO);
        return this.repositorioActividadGestionEstrategica.eliminarDocumento(id);
    }
}
