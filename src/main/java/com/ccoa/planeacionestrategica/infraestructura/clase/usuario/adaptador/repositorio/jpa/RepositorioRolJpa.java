package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadUsuarioRol;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioRolJpa extends JpaRepository<EntidadUsuarioRol, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM EntidadUsuarioRol eur WHERE eur.usuario.idUsuario = :idUsuario")
    void eliminarRolesPorUsuarioId(Long idUsuario);

}
