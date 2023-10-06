package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadInformacionEpica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioInformacionEpicaJpa extends JpaRepository<EntidadInformacionEpica, Long> {
}
