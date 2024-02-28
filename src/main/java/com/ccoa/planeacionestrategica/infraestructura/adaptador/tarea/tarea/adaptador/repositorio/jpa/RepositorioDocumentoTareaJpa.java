package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.tarea.adaptador.entidad.EntidadDocumentoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoTareaJpa extends JpaRepository<EntidadDocumentoTarea,Long> {
    List<EntidadDocumentoTarea> findByIdTarea(Long idTarea);
}
