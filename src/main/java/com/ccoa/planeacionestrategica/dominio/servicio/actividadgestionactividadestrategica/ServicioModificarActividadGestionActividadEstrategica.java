package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarActividadGestionActividadEstrategica {

    private final RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica;

    public ServicioModificarActividadGestionActividadEstrategica(RepositorioActividadGestionActividadEstrategica repositorioActividadGestionActividadEstrategica) {
        this.repositorioActividadGestionActividadEstrategica = repositorioActividadGestionActividadEstrategica;
    }

    public Long ejecutarModificar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, Long codigo){

        if(this.repositorioActividadGestionActividadEstrategica.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_ACTIVIDAD_DE_GESTION_DE_LA_ACTIVIDAD_ESTRATEGICA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestionActividadEstrategica.modificar(actividadGestionActividadEstrategica,codigo);
    }
}
