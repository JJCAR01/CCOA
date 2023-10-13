package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividadEstrategicaJpa extends JpaRepository<EntidadActividadEstrategica,Long> {
    EntidadActividadEstrategica findByNombre(String nombre);
    //EntidadActividadEstrategica findByIdInformacionEpica(Long idInformacionEpica);
}
