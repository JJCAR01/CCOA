package com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;

import java.util.List;

public interface RepositorioObservacionSprintProyectoArea {

    List<DtoObservacionSprintProyectoArea> listar();
    ObservacionSprintProyectoArea consultarPorId(Long id);
    Long guardar(ObservacionSprintProyectoArea observacionSprintProyectoArea);
    boolean existe(ObservacionSprintProyectoArea observacionSprintProyectoArea);
    List<DtoObservacionSprintProyectoArea> consultarPorIdSprintProyectoArea(Long idSprintProyectoArea);
}
