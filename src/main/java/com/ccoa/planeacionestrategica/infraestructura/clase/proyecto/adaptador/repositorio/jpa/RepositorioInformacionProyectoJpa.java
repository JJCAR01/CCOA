package com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.proyecto.adaptador.entidad.EntidadInformacionProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionProyectoJpa extends JpaRepository<EntidadInformacionProyecto,Long> {
}
