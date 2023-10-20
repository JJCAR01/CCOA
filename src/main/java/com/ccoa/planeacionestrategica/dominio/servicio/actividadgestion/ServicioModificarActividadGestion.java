package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.mensaje.Mensajes.NO_EXISTE_LA_ACTIVIDAD_GESTION_DEL_AREA_CON_LOS_DATOS_INGRESADOS;
import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarActividadGestion {
    private final RepositorioActividadGestion repositorioActividadGestion;

    public ServicioModificarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }

    public Long ejecutarModificar(ActividadGestion actividadGestion, Long codigo){

        if(this.repositorioActividadGestion.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(NO_EXISTE_LA_ACTIVIDAD_GESTION_DEL_AREA_CON_LOS_DATOS_INGRESADOS,MENSAJE_DEFECTO);

        return this.repositorioActividadGestion.modificar(actividadGestion,codigo);
    }
}
