package com.ccoa.planeacionestrategica.dominio.servicio.actividad;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarActividad {
    private static final String MENSAJE_YA_EXISTE = "Ya existe la actividad con los datos ingresados";

    private final RepositorioActividad repositorioActividad;

    public ServicioGuardarActividad(RepositorioActividad repositorioActividad) {
        this.repositorioActividad = repositorioActividad;
    }

    public Long ejecutarGuardar(Actividad actividad, InformacionActividad informacionActividad){
        //if(this.repositorioActividad.existe(actividad)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioActividad.guardar(actividad,informacionActividad);
    }
}
