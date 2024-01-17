package com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadestrategica.adaptador.entidad.EntidadInformacionActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioInformacionActividadEstrategicaJpa extends JpaRepository<EntidadInformacionActividadEstrategica, Long> {
    List<EntidadInformacionActividadEstrategica> findByIdPat(Long idPat);

    void deleteByIdPat(Long idPat);

}
