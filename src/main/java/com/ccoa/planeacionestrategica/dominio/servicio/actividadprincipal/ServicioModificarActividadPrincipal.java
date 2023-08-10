package com.ccoa.planeacionestrategica.dominio.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.modelo.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarActividadPrincipal {

    private static final String MENSAJE_NO_EXISTE = "No existe la Actividad Principal con los datos ingresados";

    private final RepositorioActividadPrincipal repositorioActividadPrincipal;

    public ServicioModificarActividadPrincipal(RepositorioActividadPrincipal repositorioActividadPrincipal) {
        this.repositorioActividadPrincipal = repositorioActividadPrincipal;
    }

    public Long ejecutarModificar(ActividadPrincipal actividadPrincipal, Long codigo){

        if(this.repositorioActividadPrincipal.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioActividadPrincipal.modificar(actividadPrincipal,codigo);
    }
}
