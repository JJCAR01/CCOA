package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarEpica {

    private static final String MENSAJE_YA_EXISTE = "No existe el Programa con los datos ingresados";

    private final RepositorioEpica repositorioEpica;

    public ServicioEliminarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioEpica.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioEpica.eliminar(id);
    }
}
