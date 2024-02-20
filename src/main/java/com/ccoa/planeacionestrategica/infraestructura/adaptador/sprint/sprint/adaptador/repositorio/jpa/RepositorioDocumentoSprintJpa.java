package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.adaptador.entidad.EntidadDocumentoSprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoSprintJpa extends JpaRepository<EntidadDocumentoSprint,Long> {
    List<EntidadDocumentoSprint> findByIdSprint(Long idSprint);
}
