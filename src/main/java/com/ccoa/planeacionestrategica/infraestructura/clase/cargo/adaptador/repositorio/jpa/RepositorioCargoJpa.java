package com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.cargo.adaptador.entidad.EntidadCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCargoJpa extends JpaRepository<EntidadCargo,Long> {
    EntidadCargo findByNombre(String nombre);


}
