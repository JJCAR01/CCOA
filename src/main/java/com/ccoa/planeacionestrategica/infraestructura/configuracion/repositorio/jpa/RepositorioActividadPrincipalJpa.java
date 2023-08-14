package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadActividadPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividadPrincipalJpa extends JpaRepository<EntidadActividadPrincipal,Long> {

    EntidadActividadPrincipal findByNombre(String nombre);
}
