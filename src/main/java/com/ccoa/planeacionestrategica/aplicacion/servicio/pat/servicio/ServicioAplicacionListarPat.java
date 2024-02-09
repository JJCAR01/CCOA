package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.puerto.pat.RepositorioPat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarPat {

    private final RepositorioPat repositorioPat;

    public ServicioAplicacionListarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public List<DtoPatResumen> ejecutar(){return this.repositorioPat.listar();}

    public DtoPatResumen consultarById(Long id){return this.repositorioPat.consultarPorId(id);}
}
