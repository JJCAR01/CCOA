package com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion;


import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;
import java.util.List;
public interface RepositorioActividadGestion {

    List<DtoActividadGestionResumen> listar();
    List<DocumentoActividadGestion> consultarPorIdParaObtenerDocumento(Long id);
    ActividadGestion consultarPorId(Long id);
    Long guardar(ActividadGestion actividadGestion, InformacionActividadGestion informacionActividadGestion);
    Long guardarDocumento(DocumentoActividadGestion documentoActividadGestion, Long codigo);
    boolean existe(ActividadGestion actividadGestion);
    boolean existeDocumento(DocumentoActividadGestion documentoActividadGestion);
    Long eliminar(Long id);
    Long eliminarPorPat(Long id);
    Long modificar(ActividadGestion actividadGestion,InformacionActividadGestion informacionActividadGestion, Long id);
    List<DtoActividadGestionResumen> consultarPorIdPat(Long idPat);
    List<DtoIdsActividadGestion> consultarPorIdPatAEliminar(Long idPat);
    Long modificarDocumento(DocumentoActividadGestion documentoActividadGestion, Long id);
    Long eliminarDocumento(Long id);
}


