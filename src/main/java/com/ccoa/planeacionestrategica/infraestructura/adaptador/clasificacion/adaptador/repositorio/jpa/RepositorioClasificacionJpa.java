package com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.adaptador.entidad.EntidadClasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioClasificacionJpa extends JpaRepository<EntidadClasificacion,Long> {

    EntidadClasificacion findByNombre(String nombre);

}
