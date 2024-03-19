package com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;

import java.util.List;

public interface RepositorioObservacionActividadEstrategica {

    List<DtoObservacionActividadEstrategica> listar();
    ObservacionActividadEstrategica consultarPorId(Long id);
    Long guardar(ObservacionActividadEstrategica observacionActividadEstrategica);
    boolean existe(ObservacionActividadEstrategica observacionActividadEstrategica);
    List<DtoObservacionActividadEstrategica> consultarPorIdActividadEstrategica(Long idTarea);
    Long eliminar(Long id);
    Long modificar(ObservacionActividadEstrategica observacionActividadEstrategica,Long id);
}
