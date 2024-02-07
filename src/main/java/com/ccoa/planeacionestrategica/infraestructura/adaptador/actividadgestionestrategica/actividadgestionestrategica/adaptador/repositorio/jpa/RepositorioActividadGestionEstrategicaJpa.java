package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.adaptador.entidad.EntidadActividadGestionEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioActividadGestionEstrategicaJpa extends JpaRepository<EntidadActividadGestionEstrategica,Long> {
    EntidadActividadGestionEstrategica findByNombre(String noombre);
    List<EntidadActividadGestionEstrategica> findByIdActividadEstrategica(Long idActividadEstartegica);
    void deleteByIdActividadEstrategica(Long idActividaEstrategica);
}
