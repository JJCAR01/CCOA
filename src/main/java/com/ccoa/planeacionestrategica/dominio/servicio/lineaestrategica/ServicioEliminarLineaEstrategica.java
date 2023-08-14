package com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarLineaEstrategica {

    private static final String MENSAJE_YA_EXISTE = "No existe la Linea Estrategica con los datos ingresados";

    private final RepositorioLineaEstrategica repositorioLineaEstrategica;

    public ServicioEliminarLineaEstrategica(RepositorioLineaEstrategica repositorioLineaEstrategica) {
        this.repositorioLineaEstrategica = repositorioLineaEstrategica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioLineaEstrategica.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioLineaEstrategica.eliminar(id);
    }

}
