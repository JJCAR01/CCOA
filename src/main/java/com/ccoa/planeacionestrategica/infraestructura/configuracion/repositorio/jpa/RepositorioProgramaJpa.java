package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProgramaJpa extends JpaRepository<EntidadPrograma,Long> {

    EntidadPrograma findByNombre(String nombre);
}
