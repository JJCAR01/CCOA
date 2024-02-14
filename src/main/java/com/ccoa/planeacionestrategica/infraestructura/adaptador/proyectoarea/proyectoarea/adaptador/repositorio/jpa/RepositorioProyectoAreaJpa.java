package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadProyecto;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProyectoAreaJpa extends JpaRepository<EntidadProyectoArea,Long> {
    EntidadProyectoArea findByNombre(String nombre);
    List<EntidadProyectoArea> findByIdPat(Long idPat);
    void deleteByIdPat(Long idPat);
}
