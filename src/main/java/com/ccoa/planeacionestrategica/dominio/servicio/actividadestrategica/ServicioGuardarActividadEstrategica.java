package com.ccoa.planeacionestrategica.dominio.servicio.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarActividadEstrategica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe la Epica del area con los datos ingresados";

    private final RepositorioActividadEstrategica repositorioActividadEstrategica;

    public ServicioGuardarActividadEstrategica(RepositorioActividadEstrategica repositorioActividadEstrategica) {
        this.repositorioActividadEstrategica = repositorioActividadEstrategica;
    }

    public Long ejecutarGuardar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica){

        if(this.repositorioActividadEstrategica.existe(actividadEstrategica)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioActividadEstrategica.guardar(actividadEstrategica,informacionActividadEstrategica);
    }


}
