package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioDetalleProyectoJpa extends JpaRepository<EntidadDetalleProyecto, Long> {
    List<EntidadDetalleProyecto> findByIdActividadEstrategica(Long idActividadEstrategica);
}
