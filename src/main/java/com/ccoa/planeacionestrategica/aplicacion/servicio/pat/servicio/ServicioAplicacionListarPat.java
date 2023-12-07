package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarPat {

    private final RepositorioPat repositorioPat;

    public ServicioAplicacionListarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public List<Pat> ejecutar(){return this.repositorioPat.listar();}

    public Pat consultarById(Long id){return this.repositorioPat.consultarPorId(id);}
}
