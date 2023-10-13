package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.InformacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.Proyecto;

import java.util.List;

public interface RepositorioProyecto {
    List<DtoProyectoResumen> listar();
    Proyecto consultarPorId(Long id);
    Long guardar(Proyecto proyecto, InformacionProyecto informacionProyecto);
    boolean existe(Proyecto proyecto);
    Long eliminar(Long id);
    Long modificar(Proyecto proyecto, Long id);
    List<DtoProyectoResumen> consultarPorIdActividadEstrategica(Long id);
}
