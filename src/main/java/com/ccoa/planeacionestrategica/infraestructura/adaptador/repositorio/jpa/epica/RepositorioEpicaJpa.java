package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.epica;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica.EntidadEpica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEpicaJpa extends JpaRepository<EntidadEpica,Long> {

    EntidadEpica findByNombre(String nombre);
}
