package com.ccoa.planeacionestrategica.dominio.puerto.actividadestrategica;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.ActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.DetalleActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.InformacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;

import java.util.List;

public interface RepositorioActividadEstrategica{
    List<DtoActividadEstrategicaResumen> listar();
    DtoActividadEstrategicaResumen consultarPorId(Long id);
    Long guardar(ActividadEstrategica actividadEstrategica, InformacionActividadEstrategica informacionActividadEstrategica,
                 DetalleActividadEstrategica detalleActividadEstrategica) ;
    boolean existe(ActividadEstrategica actividadEstrategica);
    Long eliminar(Long id);
    Long eliminarPorPat(Long id);
    Long modificar(ActividadEstrategica actividadEstrategica ,InformacionActividadEstrategica informacionActividadEstrategica,
                   DetalleActividadEstrategica detalleActividadEstrategica, Long id);
    Long modificarResultadoMeta(DetalleActividadEstrategica detalleActividadEstrategica,
            InformacionActividadEstrategica informacionActividadEstrategica, Long id);
    List<DtoActividadEstrategicaResumen> consultarPorIdPat(Long idPat);
    List<DtoIdsActividadEstrategica> consultarPorIdPatAEliminar(Long idPat);
    Long guardarDocumento(DocumentoActividadEstrategica documentoActividadEstrategica, Long codigo);
    boolean existeDocumento(DocumentoActividadEstrategica documentoActividadEstrategica);
    List<DocumentoActividadEstrategica> consultarPorIdParaObtenerDocumento(Long id);
}
