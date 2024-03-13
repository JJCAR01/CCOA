package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuarioRol;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioRolJpa extends JpaRepository<EntidadUsuarioRol, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM EntidadUsuarioRol eur WHERE eur.usuario.idUsuario = :idUsuario")
    void eliminarRolesPorUsuarioId(Long idUsuario);

    EntidadUsuarioRol findByIdUsuario(Long idUsuario);

}
