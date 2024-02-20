package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.adaptador.entidad.EntidadDocumentoSprintProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoSprintProyectoAreaJpa extends JpaRepository<EntidadDocumentoSprintProyectoArea,Long> {
    List<EntidadDocumentoSprintProyectoArea> findByIdSprintProyectoArea(Long idSprintProyectoArea);
}
