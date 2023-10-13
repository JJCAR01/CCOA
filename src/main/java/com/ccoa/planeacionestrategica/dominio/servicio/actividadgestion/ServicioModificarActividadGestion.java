package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarActividadGestion {
    private static final String MENSAJE_NO_EXISTE = "No existe la gestion del area con los datos ingresados";

    private final RepositorioActividadGestion repositorioActividadGestion;

    public ServicioModificarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }

    public Long ejecutarModificar(ActividadGestion actividadGestion, Long codigo){

        if(this.repositorioActividadGestion.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioActividadGestion.modificar(actividadGestion,codigo);
    }
}
