package com.ccoa.planeacionestrategica.dominio.servicio.lineaestrategica;

import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarLineaEstrategica {

    private static final String MENSAJE_NO_EXISTE = "No existe la Linea Estrategica con los datos ingresados";

    private final RepositorioLineaEstrategica repositorioLineaEstrategica;

    public ServicioModificarLineaEstrategica(RepositorioLineaEstrategica repositorioLineaEstrategica) {
        this.repositorioLineaEstrategica = repositorioLineaEstrategica;
    }

    public Long ejecutarModificar(LineaEstrategica lineaEstrategica, Long codigo){

        if(this.repositorioLineaEstrategica.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioLineaEstrategica.modificar(lineaEstrategica,codigo);
    }
}
