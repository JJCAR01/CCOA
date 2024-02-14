package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.adaptador.entidad.EntidadObservacionProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionProyectoAreaJpa extends JpaRepository<EntidadObservacionProyectoArea, Long> {
    List<EntidadObservacionProyectoArea> findByIdProyectoArea(long idProyectoArea);
}
