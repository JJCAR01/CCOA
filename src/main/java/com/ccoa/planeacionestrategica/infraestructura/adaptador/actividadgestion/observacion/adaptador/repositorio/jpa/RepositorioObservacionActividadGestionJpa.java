package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.adaptador.entidad.EntidadObservacionActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionActividadGestionJpa extends JpaRepository<EntidadObservacionActividadGestion, Long> {
    List<EntidadObservacionActividadGestion> findByIdActividadGestion(long idActividadGestion);
}
