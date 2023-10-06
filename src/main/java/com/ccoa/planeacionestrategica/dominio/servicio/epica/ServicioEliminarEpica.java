package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarEpica{

    private static final String MENSAJE_YA_EXISTE = "No existe la Epica con los datos ingresados";

    private final RepositorioEpica repositorioEpica;

    public ServicioEliminarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioEpica.consultarPorId(id)== null) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioEpica.eliminar(id);
    }
}
