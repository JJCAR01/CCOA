package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadEpica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEpicaJpa extends JpaRepository<EntidadEpica,Long> {
    EntidadEpica findByNombre(String nombre);
    List<EntidadEpica> findByIdPat(Long idPat);
}
