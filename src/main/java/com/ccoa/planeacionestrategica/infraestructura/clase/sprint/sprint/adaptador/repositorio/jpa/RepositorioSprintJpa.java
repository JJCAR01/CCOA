package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad.EntidadSprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSprintJpa extends JpaRepository<EntidadSprint,Long> {
    EntidadSprint findByDescripcion(String descripcion);
    List<EntidadSprint> findByIdProyecto(Long idProyecto);
}
