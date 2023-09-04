package com.ccoa.planeacionestrategica.dominio.servicio.programa;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarPrograma {

    private static final String MENSAJE_YA_EXISTE = "No existe el Programa con los datos ingresados";

    private final RepositorioPrograma repositorioPrograma;

    public ServicioEliminarPrograma(RepositorioPrograma repositorioPrograma) {
        this.repositorioPrograma = repositorioPrograma;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioPrograma.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioPrograma.eliminar(id);
    }
}
