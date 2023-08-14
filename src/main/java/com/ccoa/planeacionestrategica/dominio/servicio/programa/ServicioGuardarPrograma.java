package com.ccoa.planeacionestrategica.dominio.servicio.programa;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPrograma {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Programa con los datos ingresados";

    private final RepositorioPrograma repositorioPrograma;

    public ServicioGuardarPrograma(RepositorioPrograma repositorioPrograma) {
        this.repositorioPrograma = repositorioPrograma;
    }

    public Long ejecutarGuardar(Programa programa){

        if(this.repositorioPrograma.existe(programa)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioPrograma.guardar(programa);
    }


}
