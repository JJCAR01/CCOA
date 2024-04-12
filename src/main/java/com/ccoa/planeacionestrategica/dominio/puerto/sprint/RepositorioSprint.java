package com.ccoa.planeacionestrategica.dominio.puerto.sprint;

import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.InformacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;

import java.util.List;

public interface RepositorioSprint {
    List<DtoSprintResumen> listar();
    Sprint consultarPorId(Long id);
    List<DocumentoSprint>consultarPorIdParaObtenerDocumento(Long id);
    Long guardar(Sprint sprint, InformacionSprint informacionSprint);
    Long guardarDocumento(DocumentoSprint documentoSprint,Long codigo);
    boolean existe(Sprint sprint);
    boolean existeDocumento(DocumentoSprint sprint);
    Long eliminar(Long id);
    void eliminarPorProyecto(Long id);
    Long modificar(Sprint sprint,InformacionSprint informacionSprint, Long id);
    List<DtoSprintResumen> consultarPorIdProyecto(Long idProyecto);
    List<DtoSprint> consultarPorIdProyectoParaDuplicar(Long idProyecto);
    List<DtoIdsSprint> consultarPorIdProyectoAEliminar(Long idProyecto);
    Long modificarDocumento(DocumentoSprint documentoSprint, Long id);
    Long eliminarDocumento(Long id);
}
