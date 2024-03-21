package com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.InformacionActividadGestionEstrategica;

import java.util.List;

public interface RepositorioActividadGestionEstrategica {
    List<DtoActividadGestionEstrategicaResumen> listar();
    List<DocumentoActividadGestionEstrategica> consultarPorIdParaObtenerDocumento(Long id);
    ActividadGestionEstrategica consultarPorId(Long id);
    Long guardar(ActividadGestionEstrategica actividadGestionEstrategica, InformacionActividadGestionEstrategica informacionActividadGestionActividadEstrategica);
    Long guardarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionActividadEstrategica, Long codigo);
    boolean existe(ActividadGestionEstrategica actividadGestionEstrategica);
    boolean existeDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionActividadEstrategica);
    Long eliminar(Long id);
    Long eliminarPorActividadEstrategica(Long id);
    Long modificar(ActividadGestionEstrategica actividadGestionEstrategica,
                   InformacionActividadGestionEstrategica informacionActividadGestionActividadEstrategica,Long id);
    List<DtoActividadGestionEstrategicaResumen> consultarPorIdActividadEstrategica(Long idActividadEstrategica);
    List<DtoIdsActividadGestionEstrategica> consultarPorIdActividadEstrategicaAEliminar(Long idActividadEstrategica);
    Long modificarDocumento(DocumentoActividadGestionEstrategica documentoActividadGestionEstrategica, Long id);
    Long eliminarDocumento(Long id);
}
