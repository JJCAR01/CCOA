package com.ccoa.planeacionestrategica.dominio.puerto.proyectoarea;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;

import java.util.List;

public interface RepositorioObservacionProyectoArea {

    List<DtoObservacionProyectoArea> listar();
    ObservacionProyectoArea consultarPorId(Long id);
    Long guardar(ObservacionProyectoArea observacionProyectoArea);
    boolean existe(ObservacionProyectoArea observacionProyectoArea);
    List<DtoObservacionProyectoArea> consultarPorIdProyectoArea(Long idTarea);
    Long eliminar(Long id);
    Long modificar(ObservacionProyectoArea observacionProyectoArea, Long id);
}
