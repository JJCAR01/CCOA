package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRolJpa extends JpaRepository<EntidadRol,Long> {

    EntidadRol findByRol(String rol);

}
