package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;

import java.util.List;

public interface RepositorioSprint {
    List<DtoSprintResumen> listar();
    Sprint consultarPorId(Long id);
    Long guardar(Sprint sprint);
    Long guardarDocumento(DocumentoSprint documentoSprint,Long codigo);
    boolean existe(Sprint sprint);
    Long eliminar(Long id);
    Long modificar(Sprint sprint, Long id);
    List<DtoSprintResumen> consultarPorIdProyecto(Long idProyecto);
}
