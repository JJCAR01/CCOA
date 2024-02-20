package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.actividadgestion.adaptador.entidad.EntidadDocumentoActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoActividadGestionJpa extends JpaRepository<EntidadDocumentoActividadGestion,Long> {
    List<EntidadDocumentoActividadGestion> findByIdActividadGestion(Long idActividadGestion);
}
