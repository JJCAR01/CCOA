package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.tarea;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.tarea.EntidadTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTareaJpa extends JpaRepository<EntidadTarea,Long> {

    EntidadTarea findByNombre(String nombre);
}
