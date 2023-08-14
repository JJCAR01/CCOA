package com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.modelo.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarActividadPrincipal {

    private static final String MENSAJE_YA_EXISTE = "Ya existe la Actividad principal con los datos ingresados";

    private final RepositorioActividadPrincipal repositorioActividadPrincipal;

    public ServicioGuardarActividadPrincipal(RepositorioActividadPrincipal repositorioActividadPrincipal) {
        this.repositorioActividadPrincipal = repositorioActividadPrincipal;
    }


    public Long ejecutarGuardar(ActividadPrincipal actividadPrincipal){

        if(this.repositorioActividadPrincipal.existe(actividadPrincipal)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioActividadPrincipal.guardar(actividadPrincipal);
    }


}
