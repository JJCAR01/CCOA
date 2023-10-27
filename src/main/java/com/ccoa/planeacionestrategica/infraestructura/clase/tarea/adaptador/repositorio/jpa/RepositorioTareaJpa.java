package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.EEstado;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import com.ccoa.planeacionestrategica.infraestructura.clase.tarea.adaptador.entidad.EntidadTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioTareaJpa extends JpaRepository<EntidadTarea,Long> {
    EntidadTarea findByNombre(String nombre);
    List<EntidadTarea> findByIdASE(Long idASE);
    Boolean findByEstado(EEstado estado);
    List<EntidadTarea> findByIdASEAndTipoASE(Long idASE,ETipoASE tipoASE);
}
