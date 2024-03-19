package com.ccoa.planeacionestrategica.dominio.puerto.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;

import java.util.List;

public interface RepositorioObservacionTarea {

    List<DtoObservacionTarea> listar();
    ObservacionTarea consultarPorId(Long id);
    Long guardar(ObservacionTarea observacionTarea);
    boolean existe(ObservacionTarea observacionTarea);
    List<DtoObservacionTarea> consultarPorIdTarea(Long idTarea);
    Long eliminar(Long id);
    Long modificar(ObservacionTarea observacionTarea, Long id);
}
