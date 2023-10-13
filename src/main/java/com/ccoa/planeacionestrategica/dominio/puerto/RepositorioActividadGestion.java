package com.ccoa.planeacionestrategica.dominio.puerto;


import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.InformacionActividadGestion;

import java.util.List;

public interface RepositorioActividadGestion {

    List<DtoActividadGestionResumen> listar();
    ActividadGestion consultarPorId(Long id);
    Long guardar(ActividadGestion actividadGestion, InformacionActividadGestion informacionActividadGestion);
    boolean existe(ActividadGestion actividadGestion);
    Long eliminar(Long id);
    Long modificar(ActividadGestion actividadGestion, Long id);
    List<DtoActividadGestionResumen> consultarPorIdPat(Long idPat);
}


