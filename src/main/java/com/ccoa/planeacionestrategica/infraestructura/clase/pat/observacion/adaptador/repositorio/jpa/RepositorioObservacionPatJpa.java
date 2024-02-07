package com.ccoa.planeacionestrategica.infraestructura.clase.pat.observacion.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.observacion.adaptador.entidad.EntidadObservacionPat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioObservacionPatJpa extends JpaRepository<EntidadObservacionPat, Long> {
    List<EntidadObservacionPat> findByIdPat(long idPat);
}
