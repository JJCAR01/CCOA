package com.ccoa.planeacionestrategica.infraestructura.adaptador.repositorio.jpa.programa;

import com.ccoa.planeacionestrategica.infraestructura.adaptador.entidad.programa.EntidadInformacionPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInformacionProgramaJpa extends JpaRepository<EntidadInformacionPrograma,Long> {


}
