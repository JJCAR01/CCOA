package com.ccoa.planeacionestrategica.dominio.puerto.sprintproyectoarea;

import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.InformacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;

import java.util.List;

public interface RepositorioSprintProyectoArea {
    List<DtoSprintProyectoAreaResumen> listar();
    SprintProyectoArea consultarPorId(Long id);
    List<DocumentoSprintProyectoArea>  consultarPorIdParaObtenerDocumento(Long id);
    Long guardar(SprintProyectoArea sprintProyectoArea, InformacionSprintProyectoArea informacionSprintProyectoArea);
    Long guardarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea,Long codigo);
    boolean existe(SprintProyectoArea sprintProyectoArea);
    boolean existeDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea);
    Long eliminar(Long id);
    Long modificar(SprintProyectoArea sprintProyectoArea,InformacionSprintProyectoArea informacionSprintProyectoArea, Long id);
    List<DtoSprintProyectoAreaResumen> consultarPorIdProyectoArea(Long idProyectoArea);
    Long modificarDocumento(DocumentoSprintProyectoArea documentoSprintProyectoArea, Long id);
    Long eliminarDocumento(Long id);
}
