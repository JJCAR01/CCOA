package com.ccoa.planeacionestrategica.dominio.servicio.actividadgestion;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarActividadGestion {
    private static final String MENSAJE_YA_EXISTE = "Ya existe la gestion del area con los datos ingresados";
    private final RepositorioActividadGestion repositorioActividadGestion;
    public ServicioGuardarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }
    public Long ejecutarGuardar(ActividadGestion actividadGestion, InformacionActividadGestion informacionActividadGestion) {
        if(this.repositorioActividadGestion.existe(actividadGestion)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioActividadGestion.guardar(actividadGestion,informacionActividadGestion);
    }

}
