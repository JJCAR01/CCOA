package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;

import java.util.List;

public interface RepositorioActividadEstrategica{
    List<DtoActividadEstrategicaResumen> listar();
    DtoActividadEstrategicaResumen consultarPorId(Long id);
    Long guardar(ActividadEstrategica epica, InformacionActividadEstrategica informacionEpica) ;
    boolean existe(ActividadEstrategica epica);
    Long eliminar(Long id);
    Long eliminarPorPat(Long id);
    Long modificar(ActividadEstrategica actividadEstrategica ,InformacionActividadEstrategica informacionActividadEstrategica, Long id);
    List<DtoActividadEstrategicaResumen> consultarPorIdPat(Long idPat);
    List<DtoIdsActividadEstrategica> consultarPorIdPatAEliminar(Long idPat);
}
