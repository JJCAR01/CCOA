package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadTipoGI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTipoGIJpa extends JpaRepository<EntidadTipoGI,Long> {

    EntidadTipoGI findByObservacion(String observacion);
}
