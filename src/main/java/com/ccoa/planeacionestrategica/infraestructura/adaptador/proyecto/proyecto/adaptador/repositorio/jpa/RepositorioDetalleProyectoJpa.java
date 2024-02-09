package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.adaptador.entidad.EntidadDetalleProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetalleProyectoJpa extends JpaRepository<EntidadDetalleProyecto, Long> {

}
