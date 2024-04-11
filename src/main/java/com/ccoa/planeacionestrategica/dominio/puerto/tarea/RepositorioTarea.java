package com.ccoa.planeacionestrategica.dominio.puerto.tarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsTarea;
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
    void eliminarPorActividadGestionEstrategica(Long id);
    void eliminarPorActividadGestion(Long id);
    Long modificar(Tarea tarea,InformacionTarea informacionTarea, Long id);
    Long modificarEstado(Tarea tarea,InformacionTarea informacionTarea, Long id);
    Long modificarPorcentaje(Tarea tarea,InformacionTarea informacionTarea, Long id);
    List<DtoTareaResumen> consultarPorIdActividadGestion(Long idActividadGestion, ETipoASE tipoASE);
    List<DtoTarea> consultarPorIdActividadGestionParaDuplicar(Long idActividadGestion, ETipoASE tipoASE);
    List<DtoIdsTarea> consultarPorIdActividadGestionAEliminar(Long id);
    List<DtoTareaResumen> consultarPorIdSprint(Long idSprint, ETipoASE tipoASE);
    List<DtoTarea> consultarPorIdSprintParaDuplicar(Long idSprint, ETipoASE tipoASE);
    List<DtoTareaResumen> consultarPorIdSprintProyectoArea(Long idSprintProyectoAre, ETipoASE tipoASE);
    List<DtoTarea> consultarPorIdSprintProyectoAreaParaDuplicar(Long idSprintProyectoArea, ETipoASE tipoASE);
    List<DtoTareaResumen> consultarPorIdActividadGestionActvidadEstrategica(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE);
    List<DtoTarea> consultarPorIdActividadGestionActvidadEstrategicaParaDuplicar(Long idActividadGestionActividadEstrategica, ETipoASE tipoASE);
    List<DtoIdsTarea> consultarPorIdActividadGestionEstrategicaAEliminar(Long id);
    List<DocumentoTarea>  consultarPorIdParaObtenerDocumento(Long id);
    Long guardarDocumento(DocumentoTarea documentoTarea, Long codigo);
    boolean existeDocumento(DocumentoTarea documentoTarea);
    Long modificarDocumento(DocumentoTarea documentoTarea, Long id);
    Long eliminarDocumento(Long id);
}
