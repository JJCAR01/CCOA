package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadInformacionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionUsuarioJpa extends JpaRepository<EntidadInformacionUsuario, Long> {

}
