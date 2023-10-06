package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa;

import com.ccoa.planeacionestrategica.dominio.modelo.actividad.enums.ETipoActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad.EntidadActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividadJpa extends JpaRepository<EntidadActividad,Long> {
    EntidadActividad findByTipoActividad(ETipoActividad tipoActividad);
}
