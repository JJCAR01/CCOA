package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarActividadEstrategica{

    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioEliminarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividadEstrategica.consultarPorId(id)== null) throw new ValorInvalidoExcepcion(NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadEstrategica.eliminar(id);
    }
}
