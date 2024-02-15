package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.adaptador.entidad.EntidadObservacionSprintProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionSprintProyectoAreaJpa extends JpaRepository<EntidadObservacionSprintProyectoArea, Long> {
    List<EntidadObservacionSprintProyectoArea> findByIdSprintProyectoArea(long idSprintProyectoArea);
}
