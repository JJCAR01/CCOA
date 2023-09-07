package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadDetalleActividadPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetalleActividadPrincipalJpa extends JpaRepository<EntidadDetalleActividadPrincipal,Long> {
}
