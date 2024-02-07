package com.ccoa.planeacionestrategica.dominio.servicio.tarea.observacion;

import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.puerto.tarea.RepositorioObservacionTarea;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarObservacionTarea {

    private final RepositorioObservacionTarea repositorioObservacionTarea;
    public ServicioGuardarObservacionTarea(RepositorioObservacionTarea repositorioObservacionTarea) {
        this.repositorioObservacionTarea = repositorioObservacionTarea;
    }
    public Long ejecutarGuardar(ObservacionTarea observacionTarea){
        return this.repositorioObservacionTarea.guardar(observacionTarea);
    }
}
