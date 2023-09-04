package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarPat {

    private static final String MENSAJE_NO_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioPat repositorioPat;

    public ServicioModificarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarModificar(Pat pat, Long codigo){

        if(this.repositorioPat.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioPat.modificar(pat,codigo);
    }


}
