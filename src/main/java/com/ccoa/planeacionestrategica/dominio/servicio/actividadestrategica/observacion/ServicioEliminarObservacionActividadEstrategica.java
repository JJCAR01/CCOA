package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionActividadEstrategica {

    private final RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica;

    public ServicioEliminarObservacionActividadEstrategica(RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica) {
        this.repositorioObservacionActividadEstrategica = repositorioObservacionActividadEstrategica;
    }
    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionActividadEstrategica.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadEstrategica.eliminar(id);
    }
}
