package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioActividadEstrategicaJpa extends JpaRepository<EntidadActividadEstrategica,Long> {
    EntidadActividadEstrategica findByNombre(String nombre);
    List<EntidadActividadEstrategica> findByIdPat(Long idPat);
    void deleteByIdPat(Long idPat);

}
