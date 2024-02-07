package com.ccoa.planeacionestrategica.dominio.puerto.proyecto;


import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;

import java.util.List;

public interface RepositorioObservacionProyecto {

    List<DtoObservacionProyecto> listar();
    ObservacionProyecto consultarPorId(Long id);
    Long guardar(ObservacionProyecto observacionProyecto);
    boolean existe(ObservacionProyecto observacionProyecto);
    List<DtoObservacionProyecto> consultarPorIdProyecto(Long idTarea);
}
