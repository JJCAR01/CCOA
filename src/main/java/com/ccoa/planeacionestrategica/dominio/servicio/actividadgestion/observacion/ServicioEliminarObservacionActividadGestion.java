package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion;

import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorObligatorio;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarObservacionActividadGestion {

    private final RepositorioObservacionActividadGestion repositorioObservacionActividadGestion;

    public ServicioEliminarObservacionActividadGestion(RepositorioObservacionActividadGestion repositorioObservacionActividadGestion) {
        this.repositorioObservacionActividadGestion = repositorioObservacionActividadGestion;
    }

    public Long ejecutarEliminar(Long id){
        if(this.repositorioObservacionActividadGestion.consultarPorId(id)== null) throw new
                ExcepcionValidadorObligatorio(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadGestion.eliminar(id);
    }
}
