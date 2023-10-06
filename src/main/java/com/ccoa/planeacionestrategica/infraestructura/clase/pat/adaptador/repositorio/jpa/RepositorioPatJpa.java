package com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadPat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPatJpa extends JpaRepository<EntidadPat,Long> {

    EntidadPat findByNombre(String nombre);
}
