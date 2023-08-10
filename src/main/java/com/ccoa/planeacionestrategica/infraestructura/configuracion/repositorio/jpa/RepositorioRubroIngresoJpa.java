package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadRubroIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRubroIngresoJpa extends JpaRepository<EntidadRubroIngreso,Long> {

    EntidadRubroIngreso findByNombre(String nombre);
}
