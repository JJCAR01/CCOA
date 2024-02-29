package com.ccoa.planeacionestrategica.dominio.puerto.tarea;

import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.documento.DocumentoTarea;
import com.ccoa.planeacionestrategica.dominio.transversal.enums.ETipoASE;

import java.util.List;

public interface RepositorioTarea {
    List<DtoTareaResumen> listar();
    Tarea consultarPorId(Long id);
    Long guardar(Tarea tarea, InformacionTarea informacionTarea);
    boolean existe(Tarea tarea);
    Long eliminar(Long id);
    Long modificar(Tarea tarea,InformacionTarea informacionTarea, Long id);
    Long modificarEstado(Tarea tarea,InformacionTarea informacionTarea, Long id);
    Long modificarPorcentaje(Tarea tarea,InformacionTarea informacionTarea, Long id);
    List<DtoTareaResumen> consultarPorIdActividadGestion(Long idActividadGestion, ETipoASE tipoASE);
    List<DtoTareaResumen> consultarPorIdSprint(Long idSprint, ETipoASE tipoASE);
    List<DtoTareaResumen> consultarPorIdSprintProyectoArea(Long idSprintProyectoAre, ETipoASE tipoASE);
    List<DtoTareaResumen> consultarPorIdActividadGestionActvidadEstrategica(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE);
    List<DocumentoTarea>  consultarPorIdParaObtenerDocumento(Long id);
    Long guardarDocumento(DocumentoTarea documentoTarea, Long codigo);
    boolean existeDocumento(DocumentoTarea documentoTarea);
}
