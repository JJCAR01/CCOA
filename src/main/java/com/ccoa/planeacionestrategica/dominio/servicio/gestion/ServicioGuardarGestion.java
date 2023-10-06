package com.ccoa.planeacionestrategica.dominio.servicio.gestion;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarGestion {

    private static final String MENSAJE_YA_EXISTE = "Ya existe la gestion del area con los datos ingresados";
    private final RepositorioGestion repositorioGestion;
    public ServicioGuardarGestion(RepositorioGestion repositorioGestion) {
        this.repositorioGestion = repositorioGestion;
    }

    public Long ejecutarGuardar(Gestion gestion) {
        if(this.repositorioGestion.existe(gestion)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);
        return this.repositorioGestion.guardar(gestion);
    }

}
