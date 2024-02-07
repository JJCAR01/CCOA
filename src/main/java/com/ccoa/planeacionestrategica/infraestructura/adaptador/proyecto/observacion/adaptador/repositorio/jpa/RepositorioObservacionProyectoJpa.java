package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.adaptador.entidad.EntidadObservacionProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionProyectoJpa extends JpaRepository<EntidadObservacionProyecto, Long> {
    List<EntidadObservacionProyecto> findByIdProyecto(long idProyecto);
}
