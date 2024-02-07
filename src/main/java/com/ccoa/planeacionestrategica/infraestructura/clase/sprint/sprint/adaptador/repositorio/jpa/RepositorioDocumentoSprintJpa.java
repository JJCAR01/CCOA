package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.sprint.sprint.adaptador.entidad.EntidadDocumentoSprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDocumentoSprintJpa extends JpaRepository<EntidadDocumentoSprint,Long> {
}
