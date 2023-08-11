package com.ccoa.planeacionestrategica.aplicacion.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
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
