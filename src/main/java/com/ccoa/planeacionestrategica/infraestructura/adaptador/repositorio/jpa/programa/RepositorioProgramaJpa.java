package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProgramaJpa extends JpaRepository<EntidadPrograma,Long> {

    EntidadPrograma findByNombre(String nombre);
}
