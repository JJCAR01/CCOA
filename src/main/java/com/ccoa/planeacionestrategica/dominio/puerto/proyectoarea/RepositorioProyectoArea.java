package com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.DetalleProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.InformacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.ProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;

import java.util.List;

public interface RepositorioProyectoArea {
    List<DtoProyectoAreaResumen> listar();
    DtoProyectoAreaResumen consultarPorId(Long id);
    Long guardar(ProyectoArea proyectoArea, InformacionProyectoArea informacionProyectoArea, DetalleProyectoArea detalleProyectoArea);
    boolean existe(ProyectoArea proyectoArea);
    Long eliminar(Long id);
    Long eliminarPorPat(Long id);
    Long modificar(ProyectoArea proyectoArea,InformacionProyectoArea informacionProyectoArea,DetalleProyectoArea detalleProyectoArea, Long id);
    List<DtoProyectoAreaResumen> consultarPorIdPat(Long id);
    List<DtoIdsProyectoArea> consultarPorIdPatAEliminar(Long id);
    Long guardarDocumento(DocumentoProyectoArea documentoProyectoArea, Long codigo);
    boolean existeDocumento(DocumentoProyectoArea documentoProyectoArea);
    DocumentoProyectoArea consultarPorIdParaObtenerDocumento(Long id);
}
