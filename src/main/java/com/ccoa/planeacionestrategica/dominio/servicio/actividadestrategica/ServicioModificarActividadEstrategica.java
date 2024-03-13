package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ExcepcionValidadorInvalido;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarActividadEstrategica {
    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioModificarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public Long ejecutarModificar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica,
            DetalleActividadEstrategica detalleActividadEstrategica, Long codigo){
        if(this.repositorioActividadEstrategica.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadEstrategica.modificar(actividadEstrategica,informacionActividadEstrategica,detalleActividadEstrategica , codigo);
    }

    public Long modificarResultadoMeta(DetalleActividadEstrategica detalleActividadEstrategica,InformacionActividadEstrategica informacionActividadEstrategica, Long codigo){
        if(this.repositorioActividadEstrategica.consultarPorId(codigo)==null) throw new ExcepcionValidadorInvalido(NO_EXISTE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);
        return this.repositorioActividadEstrategica.modificarResultadoMeta(detalleActividadEstrategica,informacionActividadEstrategica,codigo);
    }
}
