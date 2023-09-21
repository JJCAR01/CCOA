package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarPrograma {

    private static final String MENSAJE_NO_EXISTE = "No existe el Programa con los datos ingresados";

    private final RepositorioEpica repositorioEpica;


    public ServicioModificarPrograma(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarModificar(Epica epica, Long codigo){

        if(this.repositorioEpica.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioEpica.modificar(epica,codigo);
    }

}
