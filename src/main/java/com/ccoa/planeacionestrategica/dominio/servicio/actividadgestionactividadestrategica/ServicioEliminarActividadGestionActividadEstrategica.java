package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionactividadestrategica.RepositorioActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividadGestionActividadEstrategica {
    private final RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica;

    public ServicioEliminarActividadGestionActividadEstrategica(RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica) {
        this.repositorioActividadGestionActividadEstrategica = repositorioActividadGestionActividadEstrategica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividadGestionActividadEstrategica.consultarPorId(id)== null) throw new ValorInvalidoExcepcion(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionActividadEstrategica.eliminar(id);
    }
    public Long ejecutarEliminarPorActEstrategica(Long id){

        if(this.repositorioActividadGestionActividadEstrategica.consultarPorIdActividadEstrategicaAEliminar(id)== null) throw new ValorInvalidoExcepcion(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionActividadEstrategica.eliminarPorActividadEstrategica(id);
    }
}
