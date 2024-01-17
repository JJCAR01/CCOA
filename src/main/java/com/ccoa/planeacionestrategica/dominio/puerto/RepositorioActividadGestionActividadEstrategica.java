package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.dto.ids.DtoIdsActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.InformacionActividadGestionActividadEstrategica;

import java.util.List;

public interface RepositorioActividadGestionActividadEstrategica {
    List<DtoActividadGestionActividadEstrategicaResumen> listar();
    ActividadGestionActividadEstrategica consultarPorId(Long id);
    Long guardar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica, InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica);
    boolean existe(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica);
    Long eliminar(Long id);
    Long eliminarPorActividadEstrategica(Long id);
    Long modificar(ActividadGestionActividadEstrategica actividadGestionActividadEstrategica,
            InformacionActividadGestionActividadEstrategica informacionActividadGestionActividadEstrategica,Long id);
    List<DtoActividadGestionActividadEstrategicaResumen> consultarPorIdActividadEstrategica(Long idActividadEstrategica);
    List<DtoIdsActividadGestionActividadEstrategica> consultarPorIdActividadEstrategicaAEliminar(Long idActividadEstrategica);
}
