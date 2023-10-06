package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.InformacionActividad;
import java.util.List;

public interface RepositorioActividad {
    List<DtoActividadResumen> listar();
    Actividad consultarPorId(Long id);
    Long guardar(Actividad actividad, InformacionActividad informacionActividad) ;
    boolean existe(Actividad actividad);
    Long eliminar(Long id);
    Long modificar(Actividad actividad ,Long id);
    List<Actividad> consultarPorIdGestion(Long idGestion);
    List<Actividad> consultarPorIdEpica(Long idEpica);
}