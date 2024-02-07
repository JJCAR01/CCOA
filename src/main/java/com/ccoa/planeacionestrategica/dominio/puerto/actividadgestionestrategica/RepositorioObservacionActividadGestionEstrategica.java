package com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;

import java.util.List;

public interface RepositorioObservacionActividadGestionEstrategica {

    List<DtoObservacionActividadGestionEstrategica> listar();
    ObservacionActividadGestionEstrategica consultarPorId(Long id);
    Long guardar(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica);
    boolean existe(ObservacionActividadGestionEstrategica observacionActividadGestionEstrategica);
    List<DtoObservacionActividadGestionEstrategica> consultarPorIdActividadGestionEstrategica(Long idActividadGestionEstrategica);
}
