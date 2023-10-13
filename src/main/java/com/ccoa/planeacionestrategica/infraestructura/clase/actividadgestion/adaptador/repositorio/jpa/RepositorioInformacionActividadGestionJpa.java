package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioInformacionActividadGestionJpa extends JpaRepository<EntidadInformacionActividadGestion,Long> {
}
