package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionActividadGestionEstrategica {
    private final RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica;

    public ServicioModificarObservacionActividadGestionEstrategica(RepositorioObservacionActividadGestionEstrategica repositorioObservacionActividadGestionEstrategica) {
        this.repositorioObservacionActividadGestionEstrategica = repositorioObservacionActividadGestionEstrategica;
    }
    public Long ejecutarModificar(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica, Long codigo){
        if(this.repositorioObservacionActividadGestionEstrategica.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadGestionEstrategica.modificar(observacionActividadGestionEstrategica,codigo);
    }


}
