package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.observacion.adaptador.entidad.EntidadObservacionActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionActividadEstrategicaJpa extends JpaRepository<EntidadObservacionActividadEstrategica, Long> {
    List<EntidadObservacionActividadEstrategica> findByIdActividadEstrategica(long idActividadEstrategica);
}
