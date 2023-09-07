package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.EntidadTipoGI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoGIJpa extends JpaRepository<EntidadTipoGI,Long> {

}
