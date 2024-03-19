package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionActividadGestion {
    private final RepositorioObservacionActividadGestion repositorioObservacionActividadGestion;

    public ServicioModificarObservacionActividadGestion(RepositorioObservacionActividadGestion repositorioObservacionActividadGestion) {
        this.repositorioObservacionActividadGestion = repositorioObservacionActividadGestion;
    }
    public Long ejecutarModificar(ObservacionActividadGestion observacionActividadGestion, Long codigo){
        if(this.repositorioObservacionActividadGestion.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadGestion.modificar(observacionActividadGestion,codigo);
    }


}
