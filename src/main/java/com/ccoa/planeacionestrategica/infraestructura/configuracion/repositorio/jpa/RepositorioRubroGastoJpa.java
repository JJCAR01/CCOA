package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRubroGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRubroGastoJpa extends JpaRepository<EntidadRubroGasto,Long> {

    EntidadRubroGasto findByNombre(String nombre);
}
