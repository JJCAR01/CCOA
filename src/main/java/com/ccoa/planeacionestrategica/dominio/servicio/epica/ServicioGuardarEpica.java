package com.ccoa.planeacionestrategica.dominio.servicio.epica;

import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.InformacionEpica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioEpica;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarEpica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe la Epica del area con los datos ingresados";

    private final RepositorioEpica repositorioEpica;

    public ServicioGuardarEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutarGuardar(Epica epica, InformacionEpica informacionEpica){

        if(this.repositorioEpica.existe(epica)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioEpica.guardar(epica,informacionEpica);
    }


}
