package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.actividadgestion.adaptador.entidad.EntidadInformacionActividadGestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioInformacionActividadGestionJpa extends JpaRepository<EntidadInformacionActividadGestion,Long> {

    List<EntidadInformacionActividadGestion> findByIdInformacionActividadGestion(Long idInformacionActividadGestion);

}
