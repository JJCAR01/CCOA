package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProyectoJpa extends JpaRepository<EntidadProyecto,Long> {
    EntidadProyecto findByNombre(String nombre);
    List<EntidadProyecto> findByIdActividadEstrategica(Long idActividadEstrategica);
}
