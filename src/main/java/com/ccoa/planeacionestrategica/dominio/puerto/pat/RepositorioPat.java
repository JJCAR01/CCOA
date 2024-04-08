package com.ccoa.planeacionestrategica.dominio.puerto.pat;

import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;

import java.util.List;

public interface RepositorioPat {


    List<DtoPatResumen> listar();
    DtoPatResumen consultarPorId(Long id);
    Long guardar(Pat pat, InformacionPat informacionPat) ;
    Long guardarDuplicado(Pat pat, InformacionPat informacionPat, Long codigo) ;
    boolean existe(Pat pat);
    Long eliminar(Long id);
    Long modificar(Pat pat, InformacionPat informacionPat ,Long id);

}


