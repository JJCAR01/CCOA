package com.ccoa.isotools.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.isotools.infraestructura.configuracion.entidad.EntidadArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAreaJpa extends JpaRepository<EntidadArea,Long> {

    EntidadArea findByNombre(String nombre);


}
