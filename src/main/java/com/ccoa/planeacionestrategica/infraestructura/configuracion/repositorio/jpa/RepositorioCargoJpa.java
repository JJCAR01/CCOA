package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCargoJpa extends JpaRepository<EntidadCargo,Long> {

    EntidadCargo findByNombre(String nombre);

}
