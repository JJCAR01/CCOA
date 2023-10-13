package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioInformacionActividadEstrategicaJpa extends JpaRepository<EntidadInformacionActividadEstrategica, Long> {
    List<EntidadInformacionActividadEstrategica> findByIdPat(Long idPat);
}
