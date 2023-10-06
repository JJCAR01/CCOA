package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad.EntidadInformacionActividad;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioInformacionActividadJpa extends JpaRepository<EntidadInformacionActividad, Long> {
}
