package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadSprintProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSprintProyectoAreaJpa extends JpaRepository<EntidadSprintProyectoArea,Long> {
    EntidadSprintProyectoArea findByDescripcion(String descripcion);
    List<EntidadSprintProyectoArea> findByIdProyectoArea(Long idProyectoArea);
}
