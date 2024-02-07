package com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionactividadestrategica;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.documento.DocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;

import java.util.List;

public interface RepositorioActividadGestionActividadEstrategica {
    List<DtoActividadGestionActividadEstrategicaResumen> listar();
    DocumentoActividadGestionActividadEstrategica consultarPorIdParaObtenerDocumento(Long id);
    ActividadGestionActividadEstrategica consultarPorId(Long id);
    Long guardar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica);
    Long guardarDocumento(DocumentoActividadGestionActividadEstrategica documentoActividadGestionActividadEstrategica, Long codigo);
    boolean existe(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica);
    boolean existeDocumento(DocumentoActividadGestionActividadEstrategica documentoActividadGestionActividadEstrategica);
    Long eliminar(Long id);
    Long eliminarPorActividadEstrategica(Long id);
    Long modificar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica,
            InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica,Long id);
    List<DtoActividadGestionActividadEstrategicaResumen> consultarPorIdActividadEstrategica(Long idActividadEstrategica);
    List<DtoIdsActividadGestionActividadEstrategica> consultarPorIdActividadEstrategicaAEliminar(Long idActividadEstrategica);
}
