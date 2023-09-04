package com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarLineaEstrategica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe La linea estrategica con los datos ingresados";

    private final RepositorioLineaEstrategica repositorioLineaEstrategica;

    public ServicioGuardarLineaEstrategica(RepositorioLineaEstrategica repositorioLineaEstrategica) {
        this.repositorioLineaEstrategica = repositorioLineaEstrategica;
    }

    public Long ejecutarGuardar(LineaEstrategica lineaEstrategica){

        if(this.repositorioLineaEstrategica.existe(lineaEstrategica)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioLineaEstrategica.guardar(lineaEstrategica);
    }

}
