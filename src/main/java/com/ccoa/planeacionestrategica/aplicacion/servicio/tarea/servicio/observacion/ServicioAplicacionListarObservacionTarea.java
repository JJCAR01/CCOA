package com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion;

import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionTarea;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarObservacionTarea {

    private final RepositorioObservacionTarea repositorioObservacionTarea;

    public ServicioAplicacionListarObservacionTarea(RepositorioObservacionTarea repositorioObservacionTarea) {
        this.repositorioObservacionTarea = repositorioObservacionTarea;
    }
    public List<DtoObservacionTarea> ejecutar(){return this.repositorioObservacionTarea.listar();}
    public ObservacionTarea consultarById(Long id){return this.repositorioObservacionTarea.consultarPorId(id);}
    public List<DtoObservacionTarea> consultarPorIdTarea(Long id){return this.repositorioObservacionTarea.consultarPorIdTarea(id);}
}
