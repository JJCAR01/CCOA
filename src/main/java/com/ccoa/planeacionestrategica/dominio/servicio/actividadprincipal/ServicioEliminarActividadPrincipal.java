package com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarActividadPrincipal {

    private static final String MENSAJE_YA_EXISTE = "No existe la Actvidad principal con los datos ingresados";

    private final RepositorioActividadPrincipal repositorioActividadPrincipal;

    public ServicioEliminarActividadPrincipal(RepositorioActividadPrincipal repositorioActividadPrincipal) {
        this.repositorioActividadPrincipal = repositorioActividadPrincipal;
    }


    public Long ejecutarEliminar(Long id){

        if(this.repositorioActividadPrincipal.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioActividadPrincipal.eliminar(id);
    }



}
