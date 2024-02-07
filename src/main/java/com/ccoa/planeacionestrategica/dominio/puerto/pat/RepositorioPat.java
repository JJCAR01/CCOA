package com.ccoa.planeacionestrategica.dominio.puerto.pat;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;

import java.util.List;

public interface RepositorioPat {


    List<DtoPatResumen> listar();
    Pat consultarPorId(Long id);
    Long guardar(Pat pat, InformacionPat informacionPat) ;
    boolean existe(Pat pat);
    Long eliminar(Long id);
    Long modificar(Pat pat, InformacionPat informacionPat ,Long id);

}


