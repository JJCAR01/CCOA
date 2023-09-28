package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.InformacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;

import java.util.List;

public interface RepositorioTarea {
    List<Tarea> listar();
    List<InformacionTarea> listarInformacionTarea();
    Tarea consultarPorId(Long id);
    Long guardar(Tarea tarea,InformacionTarea informacionTarea) ;
    boolean existe(Tarea tarea,InformacionTarea informacionTarea);
    Long eliminar(Long id);
    Long modificar(Tarea tarea ,Long id);
}
