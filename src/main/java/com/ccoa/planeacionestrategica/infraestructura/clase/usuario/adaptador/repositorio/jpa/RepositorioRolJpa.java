package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRolJpa extends JpaRepository<EntidadUsuarioRol, Long> {

}
