package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarEpica {

    private static final String MENSAJE_NO_EXISTE = "No existe la Epica con los datos ingresados";

    private final RepositorioEpica repositorioEpica;

    public ServicioModificarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarModificar(Epica epica, Long codigo){

        if(this.repositorioEpica.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioEpica.modificar(epica,codigo);
    }

}
