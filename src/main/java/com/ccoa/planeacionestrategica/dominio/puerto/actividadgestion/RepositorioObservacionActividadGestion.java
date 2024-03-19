package com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;

import java.util.List;

public interface RepositorioObservacionActividadGestion {

    List<DtoObservacionActividadGestion> listar();
    ObservacionActividadGestion consultarPorId(Long id);
    Long guardar(ObservacionActividadGestion observacionActividadGestion);
    boolean existe(ObservacionActividadGestion observacionActividadGestion);
    List<DtoObservacionActividadGestion> consultarPorIdActividadGestion(Long idTarea);
    Long eliminar(Long id);
    Long modificar(ObservacionActividadGestion observacionActividadGestion, Long id);
}
