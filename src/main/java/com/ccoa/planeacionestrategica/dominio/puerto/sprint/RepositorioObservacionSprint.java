package com.ccoa.planeacionestrategica.dominio.puerto.sprint;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;

import java.util.List;

public interface RepositorioObservacionSprint {

    List<DtoObservacionSprint> listar();
    ObservacionSprint consultarPorId(Long id);
    Long guardar(ObservacionSprint observacionSprint);
    boolean existe(ObservacionSprint observacionSprint);
    List<DtoObservacionSprint> consultarPorIdSprint(Long idTarea);
}
