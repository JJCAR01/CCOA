package com.ccoa.planeacionestrategica.infraestructura.configuracion.repositorio.jpa;

import com.ccoa.planeacionestrategica.infraestructura.configuracion.entidad.EntidadImperativoEstrategico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioImperativoEstrategicoJpa extends JpaRepository<EntidadImperativoEstrategico,Long> {

    EntidadImperativoEstrategico findByNombre(String nombre);
}
