package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDireccionJpa extends JpaRepository<EntidadDireccion,Long> {
}
