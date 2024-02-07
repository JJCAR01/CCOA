package com.ccoa.planeacionestrategica.dominio.puerto.sprint;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;

import java.util.List;

public interface RepositorioSprint {
    List<DtoSprintResumen> listar();
    Sprint consultarPorId(Long id);
    DocumentoSprint consultarPorIdParaObtenerDocumento(Long id);
    Long guardar(Sprint sprint, InformacionSprint informacionSprint);
    Long guardarDocumento(DocumentoSprint documentoSprint,Long codigo);
    boolean existe(Sprint sprint);
    boolean existeDocumento(DocumentoSprint sprint);
    Long eliminar(Long id);
    Long modificar(Sprint sprint,InformacionSprint informacionSprint, Long id);
    List<DtoSprintResumen> consultarPorIdProyecto(Long idProyecto);
}
