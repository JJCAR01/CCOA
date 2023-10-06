package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadGestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioGestionJpa extends JpaRepository<EntidadGestion,Long> {
    EntidadGestion findByNombre(String nombre);
    List<EntidadGestion> findByIdPat(Long idPat);
}
