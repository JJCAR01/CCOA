package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDocumentoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDocumentoProyectoJpa extends JpaRepository<EntidadDocumentoProyecto,Long> {
    List<EntidadDocumentoProyecto> findByIdProyecto(Long idProyecto);
}
