package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.adaptador.entidad.EntidadObservacionTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionTareaJpa extends JpaRepository<EntidadObservacionTarea, Long> {
    List<EntidadObservacionTarea> findByIdTarea(long idTarea);
}
