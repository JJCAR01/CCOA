package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProcesoJpa extends JpaRepository<EntidadProceso,Long> {
}
