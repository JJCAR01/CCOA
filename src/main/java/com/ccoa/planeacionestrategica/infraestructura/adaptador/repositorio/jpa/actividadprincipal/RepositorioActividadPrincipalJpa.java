package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadActividadPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividadPrincipalJpa extends JpaRepository<EntidadActividadPrincipal,Long> {

    EntidadActividadPrincipal findByNombre(String nombre);
}
