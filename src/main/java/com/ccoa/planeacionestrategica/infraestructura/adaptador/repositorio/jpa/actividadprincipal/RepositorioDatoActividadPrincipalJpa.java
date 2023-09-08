package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.actividadprincipal;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.actividadprincipal.EntidadDatoActividadPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDatoActividadPrincipalJpa extends JpaRepository<EntidadDatoActividadPrincipal,Long> {
}
