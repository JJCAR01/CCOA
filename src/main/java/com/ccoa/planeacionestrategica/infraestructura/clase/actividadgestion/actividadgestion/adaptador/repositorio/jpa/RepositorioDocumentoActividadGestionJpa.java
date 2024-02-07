package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadDocumentoActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDocumentoActividadGestionJpa extends JpaRepository<EntidadDocumentoActividadGestion,Long> {
}
