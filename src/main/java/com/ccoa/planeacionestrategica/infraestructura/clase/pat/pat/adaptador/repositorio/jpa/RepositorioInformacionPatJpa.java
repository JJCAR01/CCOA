package com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.pat.adaptador.entidad.EntidadInformacionPat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionPatJpa extends JpaRepository<EntidadInformacionPat,Long> {
}
