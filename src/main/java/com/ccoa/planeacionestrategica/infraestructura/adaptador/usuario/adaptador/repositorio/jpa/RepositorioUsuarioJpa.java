package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<EntidadUsuario,Long> {

    EntidadUsuario findByCorreo(String correo);
    EntidadUsuario findByCorreoAndPassword(String correo,String password);
}

