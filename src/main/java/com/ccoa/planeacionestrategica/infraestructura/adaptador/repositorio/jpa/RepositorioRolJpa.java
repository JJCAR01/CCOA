package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.usuario.EntidadUsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRolJpa extends JpaRepository<EntidadUsuarioRol, Long> {

    EntidadUsuarioRol findByRol(String nombreRol);
}
