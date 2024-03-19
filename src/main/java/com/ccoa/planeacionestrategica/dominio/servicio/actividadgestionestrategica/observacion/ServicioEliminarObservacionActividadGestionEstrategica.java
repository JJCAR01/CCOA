package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionActividadGestionEstrategica {

    private final RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica;

    public ServicioEliminarObservacionActividadGestionEstrategica(RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica) {
        this.repositorioObservacionActividadGestionEstrategica = repositorioObservacionActividadGestionEstrategica;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionActividadGestionEstrategica.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadGestionEstrategica.eliminar(id);
    }
}
