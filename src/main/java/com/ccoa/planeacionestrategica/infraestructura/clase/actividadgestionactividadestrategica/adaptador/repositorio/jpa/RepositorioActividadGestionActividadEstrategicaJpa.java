package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.adaptador.entidad.EntidadActividadGestionActividadEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioActividadGestionActividadEstrategicaJpa extends JpaRepository<EntidadActividadGestionActividadEstrategica,Long> {
    EntidadActividadGestionActividadEstrategica findByNombre(String noombre);
    List<EntidadActividadGestionActividadEstrategica> findByIdActividadEstrategica(Long idActividadEstartegica);
    void deleteByIdActividadEstrategica(Long idActividaEstrategica);
}
