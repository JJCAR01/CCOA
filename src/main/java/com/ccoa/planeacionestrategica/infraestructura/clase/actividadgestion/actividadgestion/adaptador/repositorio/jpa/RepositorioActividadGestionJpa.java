package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioActividadGestionJpa extends JpaRepository<EntidadActividadGestion,Long> {
    EntidadActividadGestion findByNombre(String noombre);
    List<EntidadActividadGestion> findByIdPat(Long idPat);
    void deleteByIdPat(Long idPat);
}
