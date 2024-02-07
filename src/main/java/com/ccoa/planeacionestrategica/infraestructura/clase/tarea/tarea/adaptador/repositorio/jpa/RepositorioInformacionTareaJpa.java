package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.tarea.adaptador.entidad.EntidadInformacionTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioInformacionTareaJpa extends JpaRepository<EntidadInformacionTarea,Long> {

}
