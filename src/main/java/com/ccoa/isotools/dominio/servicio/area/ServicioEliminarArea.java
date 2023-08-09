package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.isotools.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarArea {

    private static final String MENSAJE_YA_EXISTE = "No existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioEliminarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioArea.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioArea.eliminar(id);
    }
}
