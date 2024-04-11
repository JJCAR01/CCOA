package com.ccoa.planeacionestrategica.dominio.puerto.proyecto;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.DetalleProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;

import java.util.List;

public interface RepositorioProyecto {
    List<DtoProyectoResumen> listar();
    DtoProyectoResumen consultarPorId(Long id);
    Long guardar(Proyecto proyecto, InformacionProyecto informacionProyecto, DetalleProyecto detalleProyecto);
    boolean existe(Proyecto proyecto);
    Long eliminar(Long id);
    void eliminarPorActividadEstrategica(Long id);
    Long modificar(Proyecto proyecto,InformacionProyecto informacionProyecto,DetalleProyecto detalleProyecto, Long id);
    Long modificarValorEjecutado(Proyecto proyecto, Long id);
    List<DtoProyectoResumen> consultarPorIdActividadEstrategica(Long id);
    List<DtoProyecto> consultarPorIdActividadEstrategicaParaDuplicar(Long id);
    List<DtoIdsProyecto> consultarPorIdActividadEstrategicaAEliminar(Long id);
    Long guardarDocumento(DocumentoProyecto documentoProyecto, Long codigo);
    boolean existeDocumento(DocumentoProyecto documentoProyecto);
    List<DocumentoProyecto> consultarPorIdParaObtenerDocumento(Long id);
    Long modificarDocumento(DocumentoProyecto documentoProyecto, Long id);
    Long eliminarDocumento(Long id);
}
