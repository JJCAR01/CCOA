package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.adaptador.entidad.EntidadObservacionSprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionSprintJpa extends JpaRepository<EntidadObservacionSprint, Long> {
    List<EntidadObservacionSprint> findByIdSprint(long idSprint);
}
