package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.tarea;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea.EntidadInformacionTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionTareaJpa extends JpaRepository<EntidadInformacionTarea,Long> {


}
