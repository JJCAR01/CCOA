package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadLineaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLineaEstrategicaJpa extends JpaRepository<EntidadLineaEstrategica,Long> {

    EntidadLineaEstrategica findByNombre(String nombre);
}
