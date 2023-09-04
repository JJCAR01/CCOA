package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarPat {

    private static final String MENSAJE_YA_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioPat repositorioPat;

    public ServicioEliminarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioPat.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioPat.eliminar(id);
    }
}
