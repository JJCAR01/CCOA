package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarPat {

    private static final String MENSAJE_NO_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioPat repositorioPat;

    public ServicioModificarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarModificar(Pat pat, Long codigo){

        if(this.repositorioPat.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioPat.modificar(pat,codigo);
    }


}
