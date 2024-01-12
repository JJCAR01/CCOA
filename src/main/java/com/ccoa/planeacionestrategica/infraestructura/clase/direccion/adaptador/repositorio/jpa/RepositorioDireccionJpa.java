package com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioDireccionJpa extends JpaRepository<EntidadDireccion,Long> {

    EntidadDireccion findByNombre(String nombre);

}
