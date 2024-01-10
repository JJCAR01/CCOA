package com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.area.adaptador.entidad.EntidadArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAreaJpa extends JpaRepository<EntidadArea,Long> {

    EntidadArea findByNombre(String nombre);
}
