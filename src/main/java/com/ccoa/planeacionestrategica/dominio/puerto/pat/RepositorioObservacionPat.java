package com.ccoa.planeacionestrategica.dominio.puerto.pat;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.ObservacionPat;

import java.util.List;

public interface RepositorioObservacionPat {

    List<DtoObservacionPat> listar();
    ObservacionPat consultarPorId(Long id);
    Long guardar(ObservacionPat observacionPat);
    boolean existe(ObservacionPat observacionPat);
    List<DtoObservacionPat> consultarPorIdPat(Long idTarea);
}
