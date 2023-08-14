package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadLineaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLineaEstrategicaJpa extends JpaRepository<EntidadLineaEstrategica,Long> {

    EntidadLineaEstrategica findByNombre(String nombre);
}
