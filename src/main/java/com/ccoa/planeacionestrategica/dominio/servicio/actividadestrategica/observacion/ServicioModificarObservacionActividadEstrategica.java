package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarObservacionActividadEstrategica {
    private final RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica;

    public ServicioModificarObservacionActividadEstrategica(RepositorioObservacionActividadEstrategica repositorioObservacionActividadEstrategica) {
        this.repositorioObservacionActividadEstrategica = repositorioObservacionActividadEstrategica;
    }
    public Long ejecutarModificar(ObservacionActividadEstrategica observacionActividadEstrategica, Long codigo){
        if(this.repositorioObservacionActividadEstrategica.consultarPorId(codigo)==null) throw new
                ExcepcionValidadorInvalido(NO_EXISTE_LA_OBSERVACION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioObservacionActividadEstrategica.modificar(observacionActividadEstrategica,codigo);
    }


}
