package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;

import java.util.List;

public interface RepositorioActividadEstrategica{
    List<DtoActividadEstrategicaResumen> listar();
    ActividadEstrategica consultarPorId(Long id);
    Long guardar(ActividadEstrategica epica, InformacionActividadEstrategica informacionEpica) ;
    boolean existe(ActividadEstrategica epica);
    Long eliminar(Long id);
    Long modificar(ActividadEstrategica epica , Long id);
    List<DtoActividadEstrategicaResumen> consultarPorIdPat(Long idPat);
}
