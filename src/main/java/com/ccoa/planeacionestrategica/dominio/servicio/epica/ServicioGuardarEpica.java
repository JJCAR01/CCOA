package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarEpica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Programa con los datos ingresados";

    private final RepositorioEpica repositorioEpica;

    public ServicioGuardarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarGuardar(Epica programa, InformacionEpica informacionEpica){

        if(this.repositorioEpica.existe(programa,informacionEpica)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioEpica.guardar(programa,informacionEpica);
    }


}
