package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPat {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el PAT con los datos ingresados";

    private final RepositorioPat repositorioPat;

    public ServicioGuardarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarGuardar(Pat pat){

        if(this.repositorioPat.existe(pat)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioPat.guardar(pat);
    }
}
