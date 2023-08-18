package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<EntidadUsuario,Long> {

    EntidadUsuario findByNombreAndApellidos(String nombre, String apellidos);

    EntidadUsuario findByNombreUsuarioAndPassword(String nombreUsuario,String password);
}

