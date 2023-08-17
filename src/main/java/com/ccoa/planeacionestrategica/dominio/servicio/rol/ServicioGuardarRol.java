package com.ccoa.planeacionestrategica.dominio.servicio.rol;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRol;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRol {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Rol con los datos ingresados";

    private final RepositorioRol repositorioRol;

    public ServicioGuardarRol(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }

    public Long ejecutarGuardar(Rol rol){

        if(this.repositorioRol.existe(rol)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRol.guardar(rol);
    }
}
