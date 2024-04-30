package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.adaptador.entidad.EntidadDetalleActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDetalleActividadEstrategicaJpa extends JpaRepository<EntidadDetalleActividadEstrategica,Long> {

    List<EntidadDetalleActividadEstrategica> findByIdDetalleActividadEstrategica(Long idDetalleActividadEstrategica);
}
