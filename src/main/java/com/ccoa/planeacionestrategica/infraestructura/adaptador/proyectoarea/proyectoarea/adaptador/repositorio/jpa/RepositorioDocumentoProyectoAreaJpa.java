package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.adaptador.entidad.EntidadDocumentoProyectoArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoProyectoAreaJpa extends JpaRepository<EntidadDocumentoProyectoArea,Long> {
    List<EntidadDocumentoProyectoArea> findByIdProyectoArea(Long idProyectoArea);
}
