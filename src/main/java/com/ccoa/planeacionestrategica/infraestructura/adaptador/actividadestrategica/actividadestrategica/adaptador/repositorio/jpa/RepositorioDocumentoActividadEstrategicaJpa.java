package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDocumentoActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoActividadEstrategicaJpa extends JpaRepository<EntidadDocumentoActividadEstrategica,Long> {
    List<EntidadDocumentoActividadEstrategica> findByIdActividadEstrategica(Long idActividadEstrategica);
    EntidadDocumentoActividadEstrategica findByRutaDocumento(String rutaDocumento);
}
