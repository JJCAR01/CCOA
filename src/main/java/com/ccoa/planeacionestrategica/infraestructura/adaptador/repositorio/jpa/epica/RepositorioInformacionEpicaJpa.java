package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.epica;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.epica.EntidadInformacionEpica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionEpicaJpa extends JpaRepository<EntidadInformacionEpica,Long> {


}
